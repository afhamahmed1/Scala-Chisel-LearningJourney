package Lab8
import chisel3._

class Forwarding extends Module {
    val io = IO(new Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(UInt(2.W))
    val data_in = Input(UInt(32.W))
    val data_out = Output(UInt(32.W))
})


    val mem = SyncReadMem(1024, UInt(32.W))

    when (io.mask === 0.U) {
        mem.write(io.addr , io.data_in(7,0))
    }

    .elsewhen (io.mask === 1.U) {
        mem.write(io.addr , io.data_in(15,0))
    }

    .elsewhen (io.mask === 2.U) {
        mem.write(io.addr , io.data_in(23,0))
    }

    .otherwise {
        mem.write(io.addr , io.data_in(31,0))
    }
    
    io.data_out := mem.read(io.addr , io.enable)
}
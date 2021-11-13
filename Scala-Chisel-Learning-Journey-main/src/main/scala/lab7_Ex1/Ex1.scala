package Lab7

import chisel3._
import chisel3.util._

class QueuedArbiter extends Module{
    val io = IO(new Bundle{
        val in1 = Flipped(Decoupled(Input(UInt(4.W))))
        val in2 = Flipped(Decoupled(Input(UInt(4.W))))
        val in3 = Flipped(Decoupled(Input(UInt(4.W))))
        val out = Decoupled(Output(UInt(4.W)))
    })

    val arbiter = Module(new Arbiter(UInt(4.W), 3))
    val queue1 = Queue(arbiter.io.out, 3)
    val queue2 = Queue(queue1, 3)

    
    arbiter.io.in(0) <> io.in1
    arbiter.io.in(1) <> io.in2
    arbiter.io.in(2) <> io.in3
    
    io.out <> queue2
}


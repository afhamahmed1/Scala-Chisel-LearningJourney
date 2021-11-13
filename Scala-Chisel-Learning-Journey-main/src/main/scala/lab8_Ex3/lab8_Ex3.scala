package Lab8
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile

class I_Mem extends Module {
    val io = IO ( new Bundle{
        val addr = Input (UInt(10.W ))
        val inst = Output (UInt(32.W))
    } )
    
    val ins_mem = Mem (1024 , UInt(32.W))
    io.inst := ins_mem ( io.addr)
    loadMemoryFromFile ( ins_mem ,"/home/Afham_Ahmed/mem")
    
}
package lab6_Ex4

import chisel3._
import chisel3.util._

class MyQueue extends Module{
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })
    val queue = Queue(io.in, 8)
    val value = Queue(queue, 5)
    io.out <> value

}
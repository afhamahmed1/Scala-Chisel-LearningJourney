package lab5_Task2
import chisel3._
import chisel3.util._

class DataPacket[T <: Data](tipe: T) extends Bundle{
    val data = tipe
    val addr = UInt
}
class Router[T <: Data](data: T, width: UInt) extends Module{
    val io = IO(new Bundle{
        val out = Output(data)
        val adr = Output(width)
    })
    val recive = (new interface(data , width))
    io.out := recive.in
    io.adr := recive.addr
    
}

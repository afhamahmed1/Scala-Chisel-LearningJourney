package lab6
import chisel3._
import chisel3.util._

class updown(val max : Int = 10) extends Module {
    val io = IO (new Bundle {
        val set = Input (Bool())
        val out = Output (SInt(log2Ceil(max).W))
    })


    val counter = RegInit (max.S ( log2Ceil (32 ).W ) )
    when(io.set === 1.B){
        counter := counter + 1.S}
    .elsewhen(counter === 0.S){
        counter := 0.S}
    .elsewhen(io.set === 0.B){
        counter := counter -1.S
    }
    .otherwise{
        counter := max.S
    }
    io.out := counter
}
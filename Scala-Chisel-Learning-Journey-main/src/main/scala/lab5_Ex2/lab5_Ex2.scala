
package lab5_Ex2
import chisel3._
import chisel3.util._

class interface[T <: Data](parameter : T) extends Bundle{
    val in_a = Input(parameter)
    val in_b = Input(parameter)
    val sel = Input(Bool())
    val output  = Output(parameter)
}
class eMux extends Module{
    val io = IO(new interface(UInt(32.W)))

    io.output := Mux(io.sel, io.in_a, io.in_b)
}
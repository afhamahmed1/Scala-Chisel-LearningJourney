package lab7
import chisel3._
import chisel3.util._

class Manchester_Encoding extends Module {
    val io = IO (new Bundle {
        val in = Input ( UInt(1.W) )
        val start = Input ( Bool () )
        val out = Output ( UInt (8. W ) )

    })
    val s0 :: s1 :: Nil = Enum (2)
    val state = RegInit(s0)
    val WaveRegister= RegInit(0.U(8.W))
    io.out := 0.U
    switch (state){
        is (s0){
            when (io.start){
                state := s1
            }.otherwise{
                io.out := WaveRegister
            }
        }
        is(s1){
            when(!io.in){
                state := s0
            }.otherwise{
                WaveRegister := (WaveRegister << 1) | io.in
                io.out := WaveRegister
            }
        }
    }
}
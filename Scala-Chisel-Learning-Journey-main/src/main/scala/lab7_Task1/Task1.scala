package Lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class FSMIO extends Bundle{
    val f1 = Input(Bool())
    val f2 = Input(Bool())
    val r1 = Input(Bool())
    val r2 = Input(Bool())
    val out = Output(UInt(3.W))
}

class FSM extends Module{
    val io = IO(new FSMIO())
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum(6)
    val state = RegInit(s0)

    switch(state){
        is(s0){
            io.out := 0.U
            when(io.f1){
                state := s1
            }.elsewhen(!io.f1 & io.f2){
                state := s5
            }
        }
        is(s1){
            io.out := 0.U
            when(io.f1){
                state := s2
            }.elsewhen(!io.f1 & io.r1){
                state := s0
            }
        }
        is(s2){
            io.out := 3.U
            when(io.f1){
                state := s3
            }.elsewhen(!io.f1 & io.r1){
                state := s1
            }
        }
        is(s3){
            io.out := 0.U
            state := s0
        }
        is(s4){
            io.out := 7.U
            when(io.f2){
                state := s3
            }.elsewhen(!io.f2 & io.r2){
                state := s5
            }
        }
        is(s5){
            io.out := 0.U
            when(io.f2){
                state := s4
            }.elsewhen(!io.f2 & io.r2){
                state := s0
            }
        }
    }
    io.out := MuxCase(false.B, Array(
        (state === s0 || state === s1 || state === s3 || state === s5) -> 0.U,
        (state === s2) -> 3.U,
        (state === s4) -> 7.U
    ))
}
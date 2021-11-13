
// package lab3_Ex2
// import chisel3._
// import chisel3.util._

// trait Config {
//     val WLEN = 32
//     val ALUOP_SIG_LEN = 4
// }
// object ALUOP{
//     val ALU_ADD = 0.U
//     val ALU_SUB = 10.U
//     val ALU_AND = 7.U
//     val ALU_OR = 6.U
//     val ALU_XOR = 4.U
//     val ALU_SLT = .U
//     val ALU_SLL = .U
//     val ALU_SLTU =.U
//     val ALU_SRL = .U
//     val ALU_SRA = .U
//     val ALU_COPY_X = .U
//     val ALU_COPY_Y = .U
//     val ALU_FN_X = BitPat("b????")
    
//     val ALU_BEQ = "b10000".U
//     val ALU_BNE = "b10001".U
//     val ALU_BLT = "b10100".U
//     val ALU_BGE = "b10101".U
//     val ALU_BLTU = "b10110".U
//     val ALU_BGEU = "b10111".U

    
// }
// class interface extends Bundle with Config {
//     val in = Input(Vec(2, UInt(WLEN.W)))
//     val fun = Input(UInt(ALUOP_SIG_LEN.W))
//     val out = Output(UInt(WLEN.W))
//     val sum = Output(UInt(WLEN.W))
//     val cmp = Output(UInt(WLEN.W))
// }

// class lab3_Ex2 extends Module with Config {
//     val io = IO(new interface)
//     io.out := 0.U
//     switch (io.fun){
//         is (ALUOP.ALU_ADD ) {
//             io.out := (io.in(1)).asSInt + (io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_SUB){
//             io.out := (io.in(1)).asSInt - (io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_AND){
//             io.out := (io.in(1)).asSInt & (io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_OR){
//             io.out := (io.in(1)).asSInt | (io.in(2)).asSInt
//         }  
//         is (ALUOP.ALU_XOR){
//             io.out := (io.in(1)).asSInt ^ (io.in(2)).asSInt
//         }  
//         is (ALUOP.ALU_SLT){
//             io.out := (io.in(1)).asSInt < (io.in(2)).asSInt
//         }  
//         is (ALUOP.ALU_SLL){
//             io.out := (io.in(1)).asSInt << io.in(2)(4,0)
//         }  
//         is (ALUOP.ALU_SLTU){
//             io.out := io.in(1) < io.in(2)
//         }     
//          is (ALUOP.ALU_SRL){
//              io.out := (io.in(1)) >> io.in(2)(4,0)
//         }  
//         is (ALUOP.ALU_SRA){
//             io.out := (io.in(1)).asSInt >> io.in(2)(4,0)
//         }  
//         is (ALUOP.ALU_BEQ){
//             io.out := 0.S +& (io.in(1) === io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_BNE){
//             io.out := 0.S +& (io.in(1) =/= io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_BLT){
//             io.out := 0.S +& (io.in(1) < io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_BGE){
//             io.out := 0.S +& (io.in(1) >= io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_BLTU){
//             io.out := 0.S +& (io.in(1) < io.in(2)).asSInt
//         }
//         is (ALUOP.ALU_BGEU){
//             io.out := 0.U +& (io.in(1) >= io.in(2))
//         }
//         is (ALUOP.ALU_COPY_X){
//             io.out := io.in(1)
//         }
//         is (ALUOP.ALU_COPY_Y){
//             io.out := io.in(2)
//         }
//         is (ALUOP.ALU_FN_X){
//             io.out := 0.U
//         }
        
        
//     }
// }
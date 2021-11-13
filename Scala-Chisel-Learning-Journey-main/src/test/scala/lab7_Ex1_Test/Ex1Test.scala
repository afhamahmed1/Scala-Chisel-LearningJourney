package Lab7

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestQueuedArbiter extends FreeSpec with ChiselScalatestTester{
    "Queued Arbiter" in {
        test(new QueuedArbiter()){z =>
            // POKES
            // in1
            z.io.in1.valid.poke(1.B)
            z.io.in1.bits.poke(5.U)
            // in2
            z.io.in2.valid.poke(1.B)
            z.io.in2.bits.poke(3.U)
            // in3
            z.io.in3.valid.poke(1.B)
            z.io.in3.bits.poke(7.U)
            // out
            z.io.out.ready.poke(1.B)

            z.clock.step(2)

            //EXPECTS
            // in1
            z.io.in1.ready.expect(1.B)
            // in2
            z.io.in2.ready.expect(0.B)
            // in3
            z.io.in3.ready.expect(0.B)
            // out
            z.io.out.valid.expect(1.B)
            z.io.out.bits.expect(5.U)
        }
    }
}

// SIMPLE ARBITER TEST:-
// 
// class TestSimpleArbiter extends FreeSpec with ChiselScalatestTester{
//     "Queued Arbiter" in {
//         test(new SimpleArbiter()){z =>
//             // POKES
//             // in1
//             z.io.in1.valid.poke(1.B)
//             z.io.in1.bits.poke(5.U)
//             // in2
//             z.io.in2.valid.poke(1.B)
//             z.io.in2.bits.poke(3.U)
//             // in3
//             z.io.in3.valid.poke(1.B)
//             z.io.in3.bits.poke(7.U)
//             // out
//             z.io.out.ready.poke(1.B)

//             z.clock.step(5)

//             //EXPECTS
//             // in1
//             z.io.in1.ready.expect(1.B)
//             // in2
//             z.io.in2.ready.expect(0.B)
//             // in3
//             z.io.in3.ready.expect(0.B)
//             // out
//             z.io.out.valid.expect(1.B)
//             z.io.out.bits.expect(5.U)
//         }
//     }
// }
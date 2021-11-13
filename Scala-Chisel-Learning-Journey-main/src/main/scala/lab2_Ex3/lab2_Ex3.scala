// // Exercise 3: Refer to Listing 2.10 to create a 4-to-2 encoder using Mux1H. (Hint: You may have to use pre-determined inputs instead of ports.)

// class interface extends Bundle{
//     val select = Input(Vec(4,(Bool())))
//     val output = Output(UInt())
// }

// class lab2_Ex3 extends Module {
//     val io = IO(new interface)

//     io.output := Mux1H(select, Seq("b00", "b01", "b10", "b11"))

// }
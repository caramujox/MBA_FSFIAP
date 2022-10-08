import 'dart:math';

import 'package:dice_app/screens/dice_screen.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

void main() {
  runApp(const MyApp());
}

const _diceOne = 1;
const _diceTwo = 1;
const _maxValue = 6;
const _minValue = 1;

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.red,
      body: SafeArea(
        child: DiceScreen(diceScreenArgs: DiceScreenArgs(diceOne: _diceOne, diceTwo: _diceTwo)),
      ),
      floatingActionButton: FloatingActionButton(onPressed: (){
        print(_rdmNum(_maxValue, _minValue));
      },
      backgroundColor: Colors.lightBlue,
      // child: Text('+', style: GoogleFonts.lato(
      //                 fontSize: 26,
      //                 color: Colors.white,
      //                 fontWeight: FontWeight.bold),),
      // ),
      child: Icon(Icons.repeat),
    ));
  }

 int _rdmNum (int maxValue, int minValue) {

    return Random().nextInt((maxValue +1) - minValue);
  }
}

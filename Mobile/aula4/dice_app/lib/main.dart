import 'dart:math';

import 'package:dice_app/screens/dice_screen.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

void main() {
  runApp(const MyApp());
}


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
    return DiceScreen();
    // return Scaffold(
    //     backgroundColor: Colors.red,
    //     body: SafeArea(
    //       child: DiceScreen(
    //           diceScreenArgs:
    //               DiceScreenArgs(diceOne: _diceOne, diceTwo: _diceTwo)),
    //     ),
  }


}

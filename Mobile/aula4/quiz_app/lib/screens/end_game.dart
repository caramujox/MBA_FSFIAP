import 'package:flutter/material.dart';

class EndGameScreen extends StatelessWidget {
  static const String id = 'endGame';
  final EndGameArgs args;

  const EndGameScreen({super.key, required this.args});
  
  @override
  Widget build(Object context) {
    return Scaffold(
      body: SafeArea(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(args.correctAnswers.toString())
        ],
      )),
    );
  }
}

class EndGameArgs {
  EndGameArgs({required this.correctAnswers});
  int correctAnswers;
}
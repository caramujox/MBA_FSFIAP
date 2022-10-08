import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class DiceScreen extends StatelessWidget {
  final DiceScreenArgs diceScreenArgs;
  const DiceScreen({required this.diceScreenArgs});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Expanded(
          child: Center(
            child: Container(
              child: Image.asset('assets/images/dice1.png'),
            ),
          ),
        ),
        Expanded(
          child: Center(
            child: Container(
              child: Image.asset('assets/images/dice1.png'),
            ),
          ),
        ),
      ],
    ));
  }


}

class DiceScreenArgs {
  const DiceScreenArgs({required this.diceOne, required this.diceTwo});

  final int diceOne, diceTwo;
}
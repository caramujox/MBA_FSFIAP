import 'dart:math';

import 'package:flutter/material.dart';

class DiceScreen extends StatefulWidget {
  final _diceOne = 1;
  final _diceTwo = 1;
  static const _maxValue = 6;
  static const _minValue = 1;

  @override
  State<DiceScreen> createState() => _DiceScreenState();
}

class _DiceScreenState extends State<DiceScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.red,
      body: SafeArea(
        child: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Expanded(
                child: Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Image.asset(
                        'assets/images/dice${_rdmNum(DiceScreen._maxValue, DiceScreen._minValue)}.png'),
                  ),
                ),
              ),
              Expanded(
                child: Container(
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Image.asset(
                        'assets/images/dice${_rdmNum(DiceScreen._maxValue, DiceScreen._minValue)}.png'),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            //   arguments. = _rdmNum(_maxValue, _minValue);
            //   _diceTwo = _rdmNum(_maxValue, _minValue);
            //   print("Dice one: $_diceOne");
            //   print("Dice two: $_diceTwo");
            // });
            // print(_rdmNum(_maxValue, _minValue)
          });
        },
        backgroundColor: Colors.lightBlue,
        child: Icon(Icons.repeat),
      ),
    );
  }
}

class DiceScreenArgs {
  const DiceScreenArgs({required this.diceOne, required this.diceTwo});

  final int diceOne, diceTwo;
}

int _rdmNum(int maxValue, int minValue) {
  return Random().nextInt(maxValue - minValue) + minValue;
}

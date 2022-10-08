import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class QuestionButton extends StatelessWidget {
  final String text;
  final VoidCallback onPressed;

  const QuestionButton(
      {super.key, required this.text, required this.onPressed});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onPressed,
      child: Material(
        color: Colors.indigo,
        elevation: 8,
        borderRadius: BorderRadius.circular(8),
        child: Center(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 10),
            child: Text(text, style: const TextStyle(
              color: Colors.white
            ),),
          ),
        ),
      ),
    );
  }
}

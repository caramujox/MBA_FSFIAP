import 'package:flutter/material.dart';
import 'package:quiz_app/screens/end_game.dart';
import 'package:quiz_app/screens/quiz_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const QuizScreen(title: 'Flutter Demo Home Page'),
      routes: {
        QuizScreen.id: (context) => const QuizScreen(title: 'Quiz Screen'),
        EndGameScreen.id: (context) => EndGameScreen(args: ModalRoute.of(context)?.settings.arguments as EndGameArgs,)
      },
    );
  }
}

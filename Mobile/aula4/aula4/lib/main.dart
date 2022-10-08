import 'package:aula4/screens/menu_screen.dart';
import 'package:aula4/screens/personal_card_screen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
      routes: {
        MenuScreen.id: (context)=> MenuScreen(),
        PersonalCardScreen.id: (context) => PersonalCardScreen(
          arguments: ModalRoute.of(context)?.settings.arguments as PersonalCardScreenArgs,
        )
      },
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: MenuScreen(),
      ),
    );
  }
}
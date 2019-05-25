import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main()=> runApp(MyApp());
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Fgaleria',
      theme: ThemeData(
        primaryColor: Colors.white,
      ),
      home: RandomWords();
  }
  Widget _listBuild() => ListView(
    children: [
      _tile('Engenharia da Computação', 'DAI', Icons.computer),
      _tile('Sistemas para Internet', 'DAI', Icons.alternate_email),
      _tile('Redes de Computadores', 'DAI', Icons.school),
    ],
  );
  ListTile _tile(String titulo, String departamento, IconData icon) => ListTile(
    title: Text(titulo,
        style: TextStyle(
          fontWeight: FontWeight.w500,
          fontSize: 10,
        )),
    subtitle: Text(departamento),
    leading: Icon(
      icon,
      color: Colors.blue[500],
    ),
  );
}

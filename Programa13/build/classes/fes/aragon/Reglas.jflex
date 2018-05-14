package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%% 
{WHITE} {/*Ignore*/}
";" {return PUNTOYCOMA;}
"=" {return IGUAL;}
"<" {return ME;}
"<=" {return MEI;}
"!=" {return DIST;}
">=" {return MAI;}
">" {return MA;}
"+" {return MAS;}
"-" {return MENOS;}
"||" {return OR;}
"*" {return POR;}
"/" {return DIV;}
"//" {return DIVENT;}
"%" {return MOD;}
"&&" {return AND;}
"!" {return NOT;}
"(" {return PARENTIZQ;}
")" {return PARENTDER;}
{L}({L}|{D})* {lexema=yytext(); return ID;}
("(-"{D}+")")|{D}+ {lexema=yytext(); return NUM;}
. {return ERROR;}
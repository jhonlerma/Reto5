CREATE SCHEMA FerreteriaElVagabundo;
USE FerreteriaElVagabundo;

CREATE TABLE CategoriaProducto(
id_categoriaProducto int primary key NOT NULL,
nomb_categoriaProducto varchar(40) NOT NULL
);

CREATE TABLE Productos(
codigo_productos int primary key NOT NULL,
nomb_productos varchar(40) NOT NULL,
valor_und_productos double NOT NULL,
valor_venta_productos double NOT NULL,
cantidad_productos int NOT NULL,
id_categoriaProductoFK int NOT NULL,
FOREIGN KEY(id_categoriaProductoFK) REFERENCES CategoriaProducto(id_categoriaProducto)
);

INSERT INTO CategoriaProducto VALUES(	1,	"Materiales");
INSERT INTO CategoriaProducto VALUES(	2,	"Maquinaria");
INSERT INTO CategoriaProducto VALUES(	3,	"Servicios"	);

INSERT INTO Productos VALUES(	1,	"la plastica",	107293,	134116.25,	1,	"1"	);
INSERT INTO Productos VALUES(	2,	"Acciaio",	352365,	440456.25,	2,	"1"	);
INSERT INTO Productos VALUES(	3,	"Bicchiere",	1515695,	1894618.75,	3,	"1"	);
INSERT INTO Productos VALUES(	4,	"Aluminio",	3484966,	4356207.5,	4,	"1"	);
INSERT INTO Productos VALUES(	5,	"Calcolo",	4777994,	5972492.5,	5,	"1"	);
INSERT INTO Productos VALUES(	6,	"Plexiglás",	3192174,	3990217.5,	6,	"1"	);
INSERT INTO Productos VALUES(	7,	"Otono",	5071869,	6339836.25,	7,	"1"	);
INSERT INTO Productos VALUES(	8,	"Vinilo",	8078681,	10098351.25,	8,	"1"	);
INSERT INTO Productos VALUES(	9,	"goma",	7804835,	9756043.75,	9,	"1"	);
INSERT INTO Productos VALUES(	10,	"granito",	8643081,	10803851.25,	10,	"1"	);
INSERT INTO Productos VALUES(	11,	"legna",	5647621,	7059526.25,	11,	"1"	);
INSERT INTO Productos VALUES(	12,	"Raspador",	1534279,	1917848.75,	12,	"2"	);
INSERT INTO Productos VALUES(	13,	"Camión de la basura",	3906523,	4883153.75,	13,	"2"	);
INSERT INTO Productos VALUES(	14,	"zanjadora",	2116260,	2645325,	14,	"2"	);
INSERT INTO Productos VALUES(	15,	"Dragalina",	2782476,	3478095,	15,	"2"	);
INSERT INTO Productos VALUES(	16,	"Minicargador",	9467002,	11833752.5,	16,	"2"	);
INSERT INTO Productos VALUES(	17,	"compactador",	7946979,	9933723.75,	17,	"2"	);
INSERT INTO Productos VALUES(	18,	"Calificador",	8375408,	10469260,	18,	"2"	);
INSERT INTO Productos VALUES(	19,	"Excavador",	1198640,	1498300,	19,	"2"	);
INSERT INTO Productos VALUES(	20,	"retroexcavadora",	8446223,	10557778.75,	20,	"2"	);
INSERT INTO Productos VALUES(	21,	"Excavadora",	7503758,	9379697.5,	21,	"2"	);
INSERT INTO Productos VALUES(	22,	"Tractor",	822964,	1028705,	22,	"2"	);
INSERT INTO Productos VALUES(	23,	"capa de tubería",	6099894,	7624867.5,	23,	"3"	);
INSERT INTO Productos VALUES(	24,	"Soldador",	5748563,	7185703.75,	24,	"3"	);
INSERT INTO Productos VALUES(	25,	"Pintor",	7730095,	9662618.75,	25,	"3"	);
INSERT INTO Productos VALUES(	26,	"herrero",	3433240,	4291550,	26,	"3"	);
INSERT INTO Productos VALUES(	27,	"instalador de tuberías",	6735328,	8419160,	27,	"3"	);
INSERT INTO Productos VALUES(	28,	"colocador de azulejos",	7694362,	9617952.5,	28,	"3"	);
INSERT INTO Productos VALUES(	29,	"Electricista",	9824234,	12280292.5,	29,	"3"	);
INSERT INTO Productos VALUES(	30,	"Terraza",	5371189,	6713986.25,	30,	"3"	);
INSERT INTO Productos VALUES(	31,	"Yeseros",	1118758,	1398447.5,	31,	"3"	);
INSERT INTO Productos VALUES(	32,	"Oficial de seguridad",	9002839,	11253548.75,	32,	"3"	);
INSERT INTO Productos VALUES(	33,	"Plomero",	2416279,	3020348.75,	33,	"3"	);
INSERT INTO Productos VALUES(	34,	"terminador de concreto",	2015833,	2519791.25,	34,	"3"	);
INSERT INTO Productos VALUES(	35,	"operador de equipo",	4921552,	6151940,	35,	"3"	);
INSERT INTO Productos VALUES(	36,	"refrigeración",	3729547,	4661933.75,	36,	"3"	);
INSERT INTO Productos VALUES(	37,	"albañil de cemento",	1479625,	1849531.25,	37,	"3"	);
INSERT INTO Productos VALUES(	38,	"Vidriero",	4453916,	5567395,	38,	"3"	);
INSERT INTO Productos VALUES(	39,	"mecánico de molinos",	8265279,	10331598.75,	39,	"3"	);
INSERT INTO Productos VALUES(	40,	"Obrero",	7563629,	9454536.25,	40,	"3"	);
INSERT INTO Productos VALUES(	41,	"trabajador de chapa",	9624413,	12030516.25,	41,	"3"	);
INSERT INTO Productos VALUES(	42,	"Carpintero",	2124665,	2655831.25,	42,	"3"	);
INSERT INTO Productos VALUES(	43,	"estuco de mampostería",	9250626,	11563282.5,	43,	"3"	);
INSERT INTO Productos VALUES(	44,	"calderero",	2200310,	2750387.5,	44,	"3"	);
INSERT INTO Productos VALUES(	45,	"Trabajador",	1407236,	1759045,	45,	"3"	);
INSERT INTO Productos VALUES(	46,	"impermeabilización",	8907970,	11134962.5,	46,	"3"	);
INSERT INTO Productos VALUES(	47,	"aire acondicionado",	9002367,	11252958.75,	47,	"3"	);


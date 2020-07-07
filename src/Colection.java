

import java.io.BufferedReader;
import java.io.FileReader;

public class Colection {

	AVLTree A;
        
        public Colection() {
            A = new AVLTree();
            lectura("file.txt");
            Document x = new Document("El Quijote","Miguel de Cervantes Saavedra","Oveja Negra","Bloque 1");

		Document a = new Document("El Quijote","Miguel de Cervantes Saavedra","Oveja Negra","Bloque 1");
		Document b = new Document("Harry Potter","J.K Rowling","Oveja Negra","Bloque 1");
		Document c = new Document("El señor de los Anillos","J.R.R Tolkien","Oveja Negra","Bloque 1");
		Document d = new Document("El Alquimista","Paulo Coelho","Oveja Negra","Bloque 1");
		Document e = new Document("El Código da Vinci","Dan Brown","Oveja Negra","Bloque 1");
		Document g = new Document("Crepúsculo","Stephenie Meyer","Oveja Negra","Bloque 1");
		Document f = new Document("Lo que el viento se llevó","Miguel de Cervantes Saavedra","Oveja Negra","Bloque 1");
		Document h = new Document("Citas del Presidente","Mao Tse-Tung","Oveja Negra","Bloque 1");
		Document i = new Document("El diario de Ana Frank","Anna Frank","Oveja Negra","Bloque 1");
		Document j = new Document("El enigma de la habitación 3622","DICKER, JOËL","Oveja Negra","Bloque 1");
		Document k = new Document("A propósito de nada","ALLEN, WOODY","Oveja Negra","Bloque 1");
		Document l = new Document("Los Juegos del Hambre","COLLINS SUZANNE","Oveja Negra","Bloque 1");
		Document m = new Document("La nena","MOLA, CARMEN","Oveja Negra","Bloque 1");
		Document n = new Document("Mil besos prohibidos","ÓNEGA, SONSOLES","Oveja Negra","Bloque 1");
		Document o = new Document("La madre de Frankenstein","GRANDES, ALMUDENA","Oveja Negra","Bloque 1");
		Document p = new Document("Y Julia retó a los dioses","POSTEGUILLO, SANTIAGO","Oveja Negra","Bloque 1");
		Document q = new Document("A corazón abierto","LINDO, ELVIRA","Oveja Negra","Bloque 1");
		Document r = new Document("El Quijote","Miguel de Cervantes Saavedra","Oveja Negra","Bloque 1");
		
		Document aa = new Document("Lo que el viento se llevó","Miguel de Cervantes Saavedra","Oveja Negra","Bloque 1");
		Document ba = new Document("Citas del Presidente","Mao Tse-Tung","Oveja Negra","Bloque 1");
		Document ca = new Document("El diario de Ana Frank","Anna Frank","Oveja Negra","Bloque 1");
		Document da = new Document("El enigma de la habitación 3622","DICKER, JOËL","Oveja Negra","Bloque 1");
		Document ea = new Document("A propósito de nada","ALLEN, WOODY","Oveja Negra","Bloque 1");
		Document fa = new Document("Los Juegos del Hambre","COLLINS SUZANNE","Oveja Negra","Bloque 1");
		
		A.insert(x,null);
		A.insert(a,null);
		A.insert(b,null);
		A.insert(c,null);
		A.insert(d,null);
		A.insert(e,null);
		A.insert(f,null);
		A.insert(g,null);
		A.insert(h,null);
		A.insert(i,null);
		A.insert(j,null);
		A.insert(k,null);
		A.insert(l,null);
		A.insert(m,null);
		A.insert(n,null);
		A.insert(o,null);
		A.insert(p,null);
		A.insert(q,null);
		A.insert(r,null);
		A.insert(x,null);
		A.insert(x,null);
		A.insert(j,null);
		A.insert(k,null);
		A.insert(l,null);
		A.insert(d,null);
		A.insert(fa,null);
		
		A.insert(aa,null);
		A.insert(ba,null);
		A.insert(ca,null);
		A.insert(da,null);
		A.insert(ea,null);

	}
        
	public void lectura(String documento) {									//Lectura de archivo y creación de árbol.
	
		try {

			BufferedReader buffer = new BufferedReader(new FileReader(documento));
			
			String datos;
			do {
				datos = buffer.readLine();

				String[] partes = datos.split(",");
				Document nodo = new Document(partes[0], partes[1], partes[2], partes[3]);
				A.insert(nodo, null);

			} while (datos != null);
			
			buffer.close();

		} catch (Exception e) {

		}
	}

	
}

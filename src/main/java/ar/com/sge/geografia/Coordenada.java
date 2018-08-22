package ar.com.sge.geografia;

public class Coordenada {
	private float latitud;
	private float longitud;
	
	public Coordenada(float unLatitud,float unLongitud) {
		this.latitud=unLatitud;
		this.longitud=unLongitud;
	}// constructor
	
	public float getLatitud() {
		return latitud;
	}
	
	public float getLongitud() {
		return longitud;
	}
	
	//distanciaEntre2Punto = raiz[(x2-x1)^2+(x2-x1)^2]
	//distanciaEntre2Punto = raiz[distLat+distLong]
	//siendo p1=(x1,y1) y p2=(x2,y2)
	

	public float distanciaAlPunto(Coordenada unPunto) {
		float distancia,distLat,distLong;
		distLat=(float) Math.pow((unPunto.getLatitud() - this.getLatitud()),2);
		distLong=(float) Math.pow((unPunto.getLongitud() - this.getLongitud()),2);
		distancia= (float) Math.pow(distLat+distLong, -2);
		return distancia;
	}
	
	

}// fin Coordenada

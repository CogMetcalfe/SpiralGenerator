package spiral;

public class SpiralGen{
	
	public static int getVal(int a, int b, int c) {
		return (a*a-(a - 2*(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))*(a - 2*(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))) + (((c-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))<=(b-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1)))))?(b-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))+(c-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1)))):(((a - 2*(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))-1)*2) + Math.abs(((a - 2*(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))-(b-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))-1)+((a - 2*(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))-(c-(Math.min(Math.min(b,c),Math.min(a-b-1,a-c-1))))-1))) + 1;
	}
	
//	The above is an obsfuscated version of this commented function, it is a mathematical way to calculate the value of position in a certain size square
//	public static int getVal(int side, int x, int y) {
//		int distanceToEdge = Math.min(Math.min(x,y),Math.min(side-x-1,side-y-1));
//		int localSide = side - 2*distanceToEdge;
//		int nonLocalArea = (int)(Math.pow(side, 2)-Math.pow(localSide, 2));
//		int localX, localY;
//		localX = x-distanceToEdge;
//		localY = y-distanceToEdge;
//		int shellValue;
//		//shellValue = (localY<=localX)?localX+localY:((localSide-1)*2) + Math.abs((localSide-localX-1)+(localSide-localY-1));
//		if(localY<=localX) {
//			shellValue = localX + localY;
//		}else {
//			shellValue = ((localSide-1)*2) + Math.abs((localSide-localX-1)+(localSide-localY-1));
//		}
//		return nonLocalArea + shellValue + 1;
//	}
	
	//This is for the above approach
	public static int[][] getSpiral(int side){
		int[][] spiral = new int[side][side];
		for(int x=0;x<side;x++) {
			for(int y=0;y<side;y++) {
				spiral[x][y] = getVal(side, x,y);
			}
		}
		return spiral;
	}
	
	//This function is the programmatical approach, snaking through the grid, incrementing the value
	public static int[][] getSpiralEZ(int side) {
		int[][] spiral = new int[side][side];
		int x, y;
		x=0;y=0;
		int dx, dy, nx, ny;
		dx=1;
		dy=0;
		spiral[0][0]=1;
		int n=2;
		while(n<=side*side) {
			nx=x+dx;
			ny=y+dy;
			if(nx>=0&&nx<side&&ny>=0&&ny<side&&spiral[nx][ny]==0) {
				//step  and change
				x=nx;
				y=ny;
				spiral[x][y]=n;
				n++;
			}else {
				//turn
				int tdx,tdy;
				tdx= -dy;
				tdy = dx;
				dx=tdx;
				dy=tdy;
			}
		}
		return spiral;
		
	}
	
	public static void printSpiral(int side) {
		if(side<=0) {return;}
		int[][] spiral = getSpiralEZ(side);
		for(int y=0;y<side;y++) {
			for(int x=0; x<side; x++) {
				System.out.print(spiral[x][y] + ", ");
			}
			System.out.println();
		}
	}
}

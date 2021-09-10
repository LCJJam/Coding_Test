package line_coding;

public class maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
		// 0,0 에서 시작
		int y = 0;
		int x = 0;
		int dir = 0; // +1 오른쪽회전 //-1 왼쪽회전
		int[] dir_y = {1,0,-1,0};
		int[] dir_x = {0,1,0,-1};
		int time = 0;
		//int next_block = 0; // x + dir_x[dir] >= 0 && x + dir_x[dir] < maze.length && y + dir_y[dir] >=0 && y+dir_y[dir] < maze.length
		while(!(x == maze.length-1 && y == maze.length-1)) {
			if(!(x + dir_x[(dir+3)%4] >= 0 && x + dir_x[(dir+3)%4] < maze.length && y + dir_y[(dir+3)%4] >=0 && y+dir_y[(dir+3)%4] < maze.length)) { // 왼쪽이 범위 밖인가? (벽인가?)
				if(x + dir_x[dir] >= 0 && x + dir_x[dir] < maze.length && y + dir_y[dir] >=0 && y+dir_y[dir] < maze.length) { // 직진이 범위 밖인가?
					if(maze[x + dir_x[dir]][y + dir_y[dir]] == 0) { 
						x += dir_x[dir];
						y += dir_y[dir];
						time +=1;
					} else {
						dir = (dir+1)%4;
					}
				} else {
					dir = (dir+1)%4;
				}
			} else {
				if( maze[x + dir_x[(dir+3)%4]][y + dir_y[(dir+3)%4]] == 0) { // 왼쪽 0? 방향 왼쪽으로 회전 후 직진 +1
					
					dir = (dir+3) %4;
					x += dir_x[dir];
					y += dir_y[dir];
					time += 1;
				}  else { // 왼쪽 블록 1 or 벽?
					if(x + dir_x[dir] >= 0 && x + dir_x[dir] < maze.length && y + dir_y[dir] >=0 && y+dir_y[dir] < maze.length) {
						if(maze[x + dir_x[dir]][y + dir_y[dir]] == 0) {
							x += dir_x[dir];
							y += dir_y[dir];
							time +=1;
						} else {
							dir = (dir+1)%4;
						}
					} else {
						dir = (dir+1)%4;
					}
				}
			}
		}

		System.out.println(time);
		
	}
	
	
	
	

}

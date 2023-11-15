import java.util.Random;

public class insertSL<T> extends SkipList{
	Random seedGenerator = new Random();
	int randomSeed = seedGenerator.nextInt() | 0x0100;

	
	@Override
	public void insert(Comparable value) {
		insert(MAX_LEVEL, level, header, value);		
	}

	private void insert(int maxLevel, int level, SkipList.SkipListNode header, Comparable value) {
		SkipListNode<T>[] forward = header.forward;
		int prevLoc;
		for(int i = 0; i < forward.length; i++) {
			if(((Comparable) forward[i].value).compareTo(value) < 0)
				prevLoc = i-1;
		//
		}
		
	}



	@Override
	public boolean contains(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	int randomLevel() {
		int x = randomSeed;
		x ^= x << 13;
		x ^= x >>> 17;
		x ^= x << 5;
		randomSeed = x;
		int level = 0;
		while((x & 1) == 0) {
			level++;
			x = x>>> 1;
		}
		return level;
	}

}

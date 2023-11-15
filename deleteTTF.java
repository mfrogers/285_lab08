
public class deleteTTF extends SkipList<T extends Comparable<T>>{

	/*
	 * Subtask 3: If your team has a fourth member, the last member will create the class deleteTTF
	 * extending the class SkipList, and implement the method delete.
	 * 
	 */
	
	
	/*
	 * @author Jove
	 * unfinished
	 * 
	 * 
	 */
	public boolean delete(T value, SkipListNode<T>[] node, ArrayList<SkipListNode<T>> predecessorNext) {
		
		if(!contains(value)) {//false if not present
			return false;
		}
		if(node.value.compareTo(value)==0) {
			if(this.level==1) {//when found and right level
				
				for() {
					node[this].next
				}
			}else {//when found but wrong level
				this.level -= 1;
				predecessorNext.add(node[this.level].next);
				this.delete(value,node[this.level],predecessorNext);
			}
			return true;
		}
		
		
		if((node.value).compareTo(value)<0) {//for when not far enough.
			if(this.delete(value,node.forward,predecessorNext)) {
				predecessorNext.add(node[this.level].next);
				return this.delete(value,node[this.level],predecessorNext);//continue
			}else {
				this.level -= 1;
				return this.delete(value, node[this.level],predecessorNext);
			}
		}
		else if(node.value.compareTo(value)>0) {//too far
			return false;
		}
		
		return false;
	}
	
}

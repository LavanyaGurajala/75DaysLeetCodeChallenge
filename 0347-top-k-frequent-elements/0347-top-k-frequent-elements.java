class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(
          (a,b)->hm.get(a)-hm.get(b) 
        );
    for(int key:hm.keySet()){
        pq.add(key);
        if(pq.size()>k){
            pq.poll();
        }
    }
    int[] res=new int[k];
    int i=0;while(!pq.isEmpty()){
        res[i++]=pq.poll();
    }
    return res;
    }
}
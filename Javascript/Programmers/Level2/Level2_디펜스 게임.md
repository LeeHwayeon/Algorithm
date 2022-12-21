# 디펜스 게임

날짜: 2022년 12월 19일
레벨: Level 2
분류: 우선순위큐

[코딩테스트 연습 - 디펜스 게임](https://school.programmers.co.kr/learn/courses/30/lessons/142085)

### 내 풀이

- js로 최대힙,최소힙 구하는 것 부터 몰라서 거의 구글링해서 푼 문제..!
- 먼저 최대힙 구현을 해보자
    
    ```jsx
    class Heap{
    	constructor(){
    		this.heap = [ null ]; // 첫번째 원소 안 씀
    	}
    
    	size(){
    		this.heap.length - 1;
    	}
    
    	push(value){
    		this.heap.push(value);
    		let curIdx = this.heap.length - 1;
    		let parIdx = Math.floor(curIdx / 2);
    
    		// curIdx가 1보다 크고, 부모의 값보다 현재 값이 더 크면 
    		while(curIdx > 1 && this.heap[parIdx] < this.heap[curIdx]){
    					// 교환
    					[ this.heap[parIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[parIdx] ];	
    					curIdx = parIdx;
    					parIdx = Math.floor(curIdx / 2);
    		}
    	}
    
    	pop(value){
    		let max = this.heap[1]; //부모 값이 제일 큼
    		if(this.heap.length <= 2) this.heap = [ null ];
    		else this.heap[1] = this.heap.pop();
    		
    		let curIdx = 1;
    		let leftIdx = curIdx * 2;
    		let rightIdx = curIdx * 2 + 1;
    
    		// 왼쪽 노드가 없으면 부모밖에 없는 것 
    		if(!this.heap[leftIdx]) return max;
    		// 오른쪽 노드가 없을 때
    		if(!this.heap[rightIdx]){
    			// 왼쪽 노드와 비교
    			if(this.heap[leftIdx] > this.heap[curIdx]){
    				[ this.heap[leftIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[leftIdx] ];	
    			}
    			return max;
    		}
    
    		// 왼쪽, 오른쪽 노드 있는 경우
    		while(this.heap[leftIdx] > this.heap[curIdx] || this.heap[rightIdx] > this.heap[curIdx]){
    			const maxIdx = this.heap[leftIdx] > this.heap[rightIdx] ? leftIdx : rightIdx;
    			[ this.heap[maxIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[maxIdx] ];	
    			curIdx = maxIdx;
    			leftIdx = curIdx * 2;
    			rightIdx = curIdx * 2 + 1;
    		}
    		return max;
    	}
    }
    ```
    
- `enemy` 수 만큼 반복
    - `remain` 에 현재 병사 수(`n`)에서 공격해오는 적의 수(`enemy[i]`)를 빼주고
    - 최대힙에 `enemy[i]`를 넣어준다
    - 만약, `remain`이 0보다 작을 때
        - `count`가 0보다 크면 최대힙에서 하나 꺼내서 `remain` 더해줌
            - `count`는 -1 감소
        - `count`가 0보다 작으면 break
    
    ```jsx
    function solution(n, k, enemy) {
        let answer = 0;
        let remain = n;
        let count = k;
        let heap = new Heap();
        
        for(let i=0; i<enemy.length; i++){
            remain -= enemy[i];
            heap.push(enemy[i]);
            
            if(remain < 0){
                if(count > 0){
                    remain += heap.pop();
                    count--;
                }else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
    ```
    
- 전체 코드
    
    ```jsx
    function solution(n, k, enemy) {
        let answer = 0;
        let remain = n;
        let count = k;
        let heap = new Heap();
        
        for(let i=0; i<enemy.length; i++){
            heap.push(enemy[i]);
            remain -= enemy[i];
    
            if(remain < 0){
                if(count){
                    remain += heap.pop();
                    count--;
                }else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
    
    class Heap{
    	constructor(){
    		this.heap = [ null ]; // 첫번째 원소 안 씀
    	}
    
    	size(){
    		this.heap.length - 1;
    	}
    
    	push(value){
    		this.heap.push(value);
    		let curIdx = this.heap.length - 1;
    		let parIdx = Math.floor(curIdx / 2);
    
    		// curIdx가 1보다 크고, 부모의 값보다 현재 값이 더 크면 
    		while(curIdx > 1 && this.heap[parIdx] < this.heap[curIdx]){
    					// 교환
    					[ this.heap[parIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[parIdx] ];	
    					curIdx = parIdx;
    					parIdx = Math.floor(curIdx / 2);
    		}
    	}
    
    	pop(value){
    		let max = this.heap[1]; //부모 값이 제일 큼
    		if(this.heap.length <= 2) this.heap = [ null ];
    		else this.heap[1] = this.heap.pop();
    		
    		let curIdx = 1;
    		let leftIdx = curIdx * 2;
    		let rightIdx = curIdx * 2 + 1;
    
    		// 왼쪽 노드가 없으면 부모밖에 없는 것 
    		if(!this.heap[leftIdx]) return max;
    		// 오른쪽 노드가 없을 때
    		if(!this.heap[rightIdx]){
    			// 왼쪽 노드와 비교
    			if(this.heap[leftIdx] > this.heap[curIdx]){
    				[ this.heap[leftIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[leftIdx] ];	
    			}
    			return max;
    		}
    
    		// 왼쪽, 오른쪽 노드 있는 경우
    		while(this.heap[leftIdx] > this.heap[curIdx] || this.heap[rightIdx] > this.heap[curIdx]){
    			const maxIdx = this.heap[leftIdx] > this.heap[rightIdx] ? leftIdx : rightIdx;
    			[ this.heap[maxIdx], this.heap[curIdx] ] = [ this.heap[curIdx], this.heap[maxIdx] ];	
    			curIdx = maxIdx;
    			leftIdx = curIdx * 2;
    			rightIdx = curIdx * 2 + 1;
    		}
    		return max;
    	}
    }
    ```
    
    - 3,4,6 테케만 실패다…. 왜지?!
    

### 찾아보니 파라메트릭 서치? 이진탐색으로도 해결 가능하다고 함

```jsx
function solution(n, k, enemy) {
    let [left, right] = [0, enemy.length];
    let mid = Math.floor((left + right) / 2);

    while (left <= right) {
        const round = enemy.slice(0, mid).sort((a, b) => b - a);
        let fever = k;
        const remain = round.reduce((acc, val) => {
            if (fever > 0) { // 비용 큰 라운드에서 무적권 쓰기
                fever--;
                return acc;
            } else return acc + val
        }, 0);
        // console.log(round, fever, remain, mid)
        if (n - remain >= 0 && fever >= 0) left = mid + 1;
        else right = mid - 1;
        mid = Math.floor((left + right) / 2);
    }

    return left - 1;
}
```

- 라운드는 0 ~ enemy.length 안에 있다
- mid 라운드 쯤에서 떨어지지 않을까? 라고 생각하며 계산하는 로직
- 무적권(k)은 비용 큰 라운드에서 적용
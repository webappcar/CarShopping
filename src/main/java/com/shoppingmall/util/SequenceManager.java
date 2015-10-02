package com.shoppingmall.util;

import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.model.Sequence;

//시퀀스번호를 가져오기 위한 클래스
public class SequenceManager {
	
	static QAMapper qaMapper;
	static Sequence sequence;
	
	public synchronized static int nextId(String tableName) {
		//synchronized= 동기화목적 : 동시에 여러사람이 사용을 할 때 접근한 사람들에게 순번을 주어 한사람이 끝나고 다음사람이 접근하도록 해줌
		System.out.println("tableName = "+tableName);
		int sequence_no = qaMapper.selectSequenceNo("QA"); //최대글번호
		System.out.println("sequence_no --- "+sequence_no);
		if(sequence_no > 0){ //검색결과가 있는경우
				int id = sequence_no; id++; //select한 첫번째 값 = 최대글번호.& 1증가
				sequence.setSequence_no(id);
				sequence.setTable_name(tableName);
				qaMapper.updateSequence(sequence);//가져온 마지막 번호를 1을 증가시켜서 LAST_ID에 다시 넣어줌

				return id;
		}else {//검색결과가 없는경우
				sequence.setSequence_no(1);
				sequence.setTable_name(tableName);
				qaMapper.insertSequence(sequence);

				return 1;
		}

	}
}
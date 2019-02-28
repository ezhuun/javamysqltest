package memo;

import java.util.Iterator;
import java.util.List;

public class MemoTest {

	public static void main(String[] args) {
		MemoDAO dao = new MemoDAO();
		// create(dao);
		// read(dao);
		// update(dao);
		// delete(dao);
		 list(dao);
	}

	private static void list(MemoDAO dao) {
		List<MemoDTO> list = dao.list();
		System.out.println("총 게시물 : " + list.size());
		if (list.size() > 0) {
			Iterator<MemoDTO> iter = list.iterator();
			while (iter.hasNext()) {
				p(iter.next());
			}
		} else {
			p("조회된 내용이 없습니다");
		}
	}

	private static void delete(MemoDAO dao) {
		if (dao.delete(1)) {
			p("레코드 삭제 성공");
		} else {
			p("레코드 삭제 실패");
		}

	}

	private static void update(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		dto.setName("김길동");
		dto.setContent("변경된 내용");
		if (dao.update(dto)) {
			p("업데이트 성공");
		} else {
			p("업데이트 실패");
		}
	}

	private static void read(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		if (dto != null) {
			p(dto);
		} else {
			p("조회된 내용이 없습니다");
		}
	}

	private static void create(MemoDAO dao) {
		MemoDTO dto = new MemoDTO();
		dto.setName("홍길동");
		dto.setContent("test내용");
		dto.setPass("test비번");

		if (dao.create(dto)) {
			p("입력 성공");
		} else {
			p("입력 실패");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(MemoDTO dto) {
		System.out.println("----------------------------");
		System.out.println("번호 : " + dto.getMemonum());
		System.out.println("이름 : " + dto.getName());
		System.out.println("내용 : " + dto.getContent());
		System.out.println("비번 : " + dto.getPass());
	}

}

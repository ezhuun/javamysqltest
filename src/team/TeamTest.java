package team;

import java.util.Iterator;
import java.util.List;

public class TeamTest {

	public static void main(String[] args) {
		TeamDAO dao = new TeamDAO();
		// create(dao);
		// read(dao);
		// update(dao);
		// delete(dao);
		list(dao);
	}

	private static void list(TeamDAO dao) {
		List<TeamDTO> list = dao.list();
		Iterator<TeamDTO> iter = list.iterator();

		while (iter.hasNext()) {
			TeamDTO dto = iter.next();
			p(dto);
			p("============");
		}
		
	}

	private static void delete(TeamDAO dao) {
		if (dao.delete(7)) {
			p("삭제 성공");
		} else {
			p("삭제 실패");
		}
	}

	private static void update(TeamDAO dao) {
		TeamDTO dto = dao.read(8);
		dto.setName("김길동");
		dto.setPhone("090-0099-0088");
		dto.setAddress("부산");
		dto.setGender("남자");
		dto.setSkill("잠자기");
		dto.setHobby("여행");

		if (dao.update(dto)) {
			p("업데이트 성공");
		} else {
			p("업데이트 실패");
		}
	}

	private static void read(TeamDAO dao) {
		TeamDTO dto = dao.read(1);
		p(dto);
	}

	private static void create(TeamDAO dao) {
		TeamDTO dto = new TeamDTO();
		dto.setName("홍길동");
		dto.setPhone("010-0011-0022");
		dto.setAddress("제주도");
		dto.setGender("남");
		dto.setSkill("잠자기");
		dto.setHobby("여행");

		if (dao.create(dto)) {
			p("입력 성공");
		} else {
			p("입력 실패");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(TeamDTO dto) {
		if (dto != null) {
			p("번호:" + dto.getTeamno());
			p("이름:" + dto.getName());
			p("전화번호:" + dto.getPhone());
			p("주소:" + dto.getAddress());
			p("성별:" + dto.getGender());
			p("특기:" + dto.getSkill());
			p("취키:" + dto.getHobby());
		} else {
			System.out.println("조회된 데이터가 없습니다");
		}
	}

}

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
			p("���� ����");
		} else {
			p("���� ����");
		}
	}

	private static void update(TeamDAO dao) {
		TeamDTO dto = dao.read(8);
		dto.setName("��浿");
		dto.setPhone("090-0099-0088");
		dto.setAddress("�λ�");
		dto.setGender("����");
		dto.setSkill("���ڱ�");
		dto.setHobby("����");

		if (dao.update(dto)) {
			p("������Ʈ ����");
		} else {
			p("������Ʈ ����");
		}
	}

	private static void read(TeamDAO dao) {
		TeamDTO dto = dao.read(1);
		p(dto);
	}

	private static void create(TeamDAO dao) {
		TeamDTO dto = new TeamDTO();
		dto.setName("ȫ�浿");
		dto.setPhone("010-0011-0022");
		dto.setAddress("���ֵ�");
		dto.setGender("��");
		dto.setSkill("���ڱ�");
		dto.setHobby("����");

		if (dao.create(dto)) {
			p("�Է� ����");
		} else {
			p("�Է� ����");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(TeamDTO dto) {
		if (dto != null) {
			p("��ȣ:" + dto.getTeamno());
			p("�̸�:" + dto.getName());
			p("��ȭ��ȣ:" + dto.getPhone());
			p("�ּ�:" + dto.getAddress());
			p("����:" + dto.getGender());
			p("Ư��:" + dto.getSkill());
			p("��Ű:" + dto.getHobby());
		} else {
			System.out.println("��ȸ�� �����Ͱ� �����ϴ�");
		}
	}

}

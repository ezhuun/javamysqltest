package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBOpen;

public class TeamDAO {
	public boolean create(TeamDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" insert into team (name, phone, address,gender, skill, hobby) values ");
		sql.append(" (?, ?, ?, ?, ?, ?) ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getSkill());
			pstmt.setString(6, dto.getHobby());

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

	public boolean update(TeamDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" update team set ");
		sql.append(" name=? ");
		sql.append(" ,phone=? ");
		sql.append(" ,address=? ");
		sql.append(" ,gender=? ");
		sql.append(" ,skill=? ");
		sql.append(" ,hobby=? ");
		sql.append(" where teamno=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getSkill());
			pstmt.setString(6, dto.getHobby());
			pstmt.setInt(7, dto.getTeamno());

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

	public boolean delete(int teamno) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" delete from team where teamno=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, teamno);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

	public TeamDTO read(int teamno) {
		TeamDTO dto = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" select * from team where teamno=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, teamno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new TeamDTO();
				dto.setTeamno(rs.getInt("teamno"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setSkill(rs.getString("skill"));
				dto.setHobby(rs.getString("hobby"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public List<TeamDTO> list() {
		List<TeamDTO> list = new ArrayList<TeamDTO>();
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from team order by teamno desc ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TeamDTO dto = new TeamDTO();
				dto.setTeamno(rs.getInt("teamno"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setSkill(rs.getString("skill"));
				dto.setHobby(rs.getString("hobby"));

				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		

		return list;
	}
}

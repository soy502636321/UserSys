package soy.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseOrganDAO;
import soy.basic.database.entity.BaseOrgan;
import soy.basic.vo.BaseOrganVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseOrganService;


public class BaseOrganServiceImpl implements BaseOrganService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseOrganServiceImpl.class);
	private static Map<Integer, String> map;

	private BaseOrganDAO baseOrganDAO;
	
	public Map<Integer, String> getMap() {
		if (SystemUtil.isEmpty(map)) {
			map = new HashMap<Integer, String>();
			map.put(0, "");
			List<BaseOrgan> list = getBaseOrganDAO().findAll();
			for (BaseOrgan baseOrgan : list) {
				map.put(baseOrgan.getId(), baseOrgan.getOrganName());
			}
		}
		return map;
	}

	public BaseOrganDAO getBaseOrganDAO() {
		return baseOrganDAO;
	}

	public void setBaseOrganDAO(BaseOrganDAO baseOrganDAO) {
		this.baseOrganDAO = baseOrganDAO;
	}

	@Override
	public SimplePaginatedList find(SimplePaginatedList paginatedList,
			BaseOrganVO organVO) {
		paginatedList = getBaseOrganDAO().find(paginatedList, organVO);
		List<BaseOrgan> baseOrgans = paginatedList.getList();
		List vos = new ArrayList();
		for(BaseOrgan baseOrgan : baseOrgans) {
			vos.add(new BaseOrganVO(baseOrgan));
		}
		paginatedList.setList(vos);
		return paginatedList;
	}

}

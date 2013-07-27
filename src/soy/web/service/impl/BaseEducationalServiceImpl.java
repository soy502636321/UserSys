package soy.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseEducationalDAO;
import soy.basic.database.entity.BaseEducational;
import soy.basic.vo.BaseEducationalVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseEducationalService;


public class BaseEducationalServiceImpl implements BaseEducationalService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseEducationalServiceImpl.class);

	private static Map<Integer, String> map;
	private BaseEducationalDAO baseEducationalDAO;

	@Override
	public Map<Integer, String> getMap() {
		if (SystemUtil.isEmpty(map)) {
			this.map = new HashMap<Integer, String>();
			map.put(0, "");
			List<BaseEducational> list = getBaseEducationalDAO().findAll();
			for (BaseEducational baseEducational : list) {
				map.put(baseEducational.getId(), baseEducational.getEducationalName());
			}
		}
		return map;
	}

	public BaseEducationalDAO getBaseEducationalDAO() {
		return baseEducationalDAO;
	}

	public void setBaseEducationalDAO(BaseEducationalDAO baseEducationalDAO) {
		this.baseEducationalDAO = baseEducationalDAO;
	}

	@Override
	public SimplePaginatedList find(SimplePaginatedList paginatedList,
			BaseEducationalVO baseEducationalVO) {
		paginatedList = getBaseEducationalDAO().find(paginatedList, baseEducationalVO);
		List<BaseEducational> baseEducationals = paginatedList.getList();
		List vos = new ArrayList();
		if (!SystemUtil.isNull(baseEducationals)) {
			for (BaseEducational baseEducational : baseEducationals) {
				vos.add(new BaseEducationalVO(baseEducational));
			}
		}
		paginatedList.setList(vos);
		return paginatedList;
	}

	@Override
	public int delete(Integer[] ids) {
		log.debug("");
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				try {
					BaseEducational baseEducational = (BaseEducational) getBaseEducationalDAO().findById(id);
					getBaseEducationalDAO().delete(baseEducational);
					size++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return size;
	}

}

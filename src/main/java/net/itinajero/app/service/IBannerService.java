package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannerService {
	
	void insertar(Banner banner);
	
	List<Banner> buscarTodos();

}

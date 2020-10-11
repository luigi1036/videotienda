package co.com.sured.videotienda.services;

import java.util.List;

import co.com.sured.videotienda.model.VideoJuego;

public interface IVideoJuegoServices {
	
	public List<VideoJuego> findAll();
	
	public VideoJuego guardar(VideoJuego videojuego);
	
	public VideoJuego actualizar(VideoJuego videojuego, Long id);
	
	public VideoJuego findById(Long id);

}

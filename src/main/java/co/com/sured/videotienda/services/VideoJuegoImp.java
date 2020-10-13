package co.com.sured.videotienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sured.videotienda.dao.IVideoJuego;
import co.com.sured.videotienda.model.VideoJuego;

@Service
public class VideoJuegoImp implements IVideoJuegoServices{
	
	@Autowired
	IVideoJuego videoJuego;

	@Override
	public List<VideoJuego> findAll() {
		return (List<VideoJuego>) videoJuego.findAll();
	}

	@Override
	public VideoJuego guardar(VideoJuego videojuego) {
		
		return videoJuego.save(videojuego);
	}

	@Override
	public VideoJuego actualizar(VideoJuego videojuego, Long id) {
		
		return videoJuego.save(videojuego);
	}

	@Override
	public VideoJuego findById(Long id) {
		
		return videoJuego.findById(id).orElse(null);
	}

}

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
		
		VideoJuego videoactual = videoJuego.findById(id).orElse(null);
		System.out.println("precio" + videojuego.getPrecioVenta());
		System.out.println("precio" + videojuego.getPrecioAlquiler());
		videoactual.setNombre(videojuego.getNombre());
		videoactual.setDirector(videojuego.getDirector());
		videoactual.setProtagonista(videojuego.getProtagonista());
		videoactual.setProductora(videojuego.getProductora());
		videoactual.setAño(videojuego.getAño());
		videoactual.setTecnologia(videojuego.getTecnologia());
		videoactual.setPrecioAlquiler(videojuego.getPrecioAlquiler());
		videoactual.setPrecioVenta(videojuego.getPrecioVenta());
		videoactual.setEstado(videojuego.getEstado());
		videoactual.setStock(videojuego.getStock());
		
		
		return videoJuego.save(videoactual);
	}

	@Override
	public VideoJuego findById(Long id) {
		
		return videoJuego.findById(id).orElse(null);
	}

}

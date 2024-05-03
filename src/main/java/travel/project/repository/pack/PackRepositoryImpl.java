package travel.project.repository.pack;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import travel.project.domain.Destination;
import travel.project.domain.Hotels;
import travel.project.domain.Restaurants;
import travel.project.mapper.CustomerMapper;
import travel.project.mapper.PackMapper;
import travel.project.repository.customer.CustomerRepositoryImpl;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PackRepositoryImpl implements PackRepository{
	
	private final PackMapper packMapper;
	
	// 호텔 등록 후 반환
	@Override
	public Hotels saveHotel(Hotels hotels) {
		packMapper.saveHotel(hotels);
		
		return packMapper.selectOne(hotels.getHotelName());
	}
	
	// 호텔 이미지 등록
	@Override
	public void saveHotelImg(List<String> imgNames, Long id) {
		packMapper.saveHotelImg(imgNames, id);
	}
	
	// 호텔 편의시설 등록
	@Override
	public void saveHotelAmenities(List<String> amenities, Long id) {
		packMapper.saveHotelAmenities(amenities, id);
	}
	
	// Destination 등록
	@Override
	public long saveDestination(Destination destination) {
		return packMapper.saveDestination(destination);
	}
	
	// Destination 리스트 반환
	@Override
	public List<Destination> findAllDestination() {
		return packMapper.findAllDestination();
	}
	
	// Restaurants 등록
	@Override
	public void saveRestaurant(Restaurants restaurants, long destination_Id) {
		packMapper.saveRestaurant(restaurants, destination_Id);
	}

}

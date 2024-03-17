package dat.nguyen.home.assistant.user.mapper;

import dat.nguyen.home.assistant.common.service.mapper.GenericMapper;
import dat.nguyen.home.assistant.user.dto.user.UserGeneralResponse;
import dat.nguyen.home.assistant.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserGeneralMapper extends GenericMapper<UserGeneralResponse, User>{
}

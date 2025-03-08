package com.krishna.kpa.task_tracker_cli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputCreate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiInputUpdate;
import com.krishna.kpa.task_tracker_cli.validation.groups.ApiOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_CREATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_ID;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_LAST_UPDATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_NAME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_PASSWORD;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerRequestResponseConstant.USER_FIELD_PHONE_NUMBER;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_PASSWORD;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.EXAMPLE_PHONE_NUMBER;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.PASSWORD_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.PHONE_NUMBER_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_CREATED_TIME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_EXAMPLE_CREATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_EXAMPLE_ID;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_EXAMPLE_LAST_UPDATED_TIME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_EXAMPLE_NAME;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_ID_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_LAST_UPDATED_TIME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerServiceConstant.USER_NAME_DESCRIPTION;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_PASSWORD_BLANK;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_PASSWORD_SIZE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_PHONE_NUMBER_BLANK;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.KEY_PHONE_NUMBER_SIZE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.USER_CREATED_TIME_NULL;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.USER_ID_POSITIVE;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.USER_LAST_UPDATED_NULL;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.USER_NAME_BLANK;
import static com.krishna.kpa.task_tracker_cli.constant.TaskTrackerValidationMessagesKeyConstants.USER_NAME_SIZE;

/**
 * DTO for user
 *
 * @author Krishna Prasad A
 */
@Getter
@Setter
public class UserDTO {

    @Schema(name = USER_FIELD_ID, description = USER_ID_DESCRIPTION, example = USER_EXAMPLE_ID)
    @JsonProperty(USER_FIELD_ID)
    @JsonView(ApiOutput.class)
    @Positive(message = "{" + USER_ID_POSITIVE + "}", groups = ApiOutput.class)
    private Integer id;

    @Schema(name = USER_FIELD_NAME, description = USER_NAME_DESCRIPTION, example = USER_EXAMPLE_NAME)
    @JsonProperty(USER_FIELD_NAME)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotBlank(message = "{" + USER_NAME_BLANK + "}", groups = {ApiInputCreate.class, ApiOutput.class})
    @Size(min = 1, max = 100, message = "{" + USER_NAME_SIZE + "}", groups = {ApiInputCreate.class, ApiInputUpdate.class, ApiOutput.class})
    private String name;

    @Schema(name = USER_FIELD_PASSWORD, description = PASSWORD_DESCRIPTION, example = EXAMPLE_PASSWORD)
    @JsonProperty(USER_FIELD_PASSWORD)
    @JsonView({ApiInputCreate.class, ApiInputUpdate.class})
    @NotBlank(message = "{" + KEY_PASSWORD_BLANK + "}", groups = {ApiInputCreate.class})
    @Size(min = 8, max = 50, message = "{" + KEY_PASSWORD_SIZE + "}", groups = {ApiInputCreate.class, ApiInputUpdate.class})
    private String password;

    @Schema(name = USER_FIELD_PHONE_NUMBER, description = PHONE_NUMBER_DESCRIPTION, example = EXAMPLE_PHONE_NUMBER)
    @JsonProperty(USER_FIELD_PHONE_NUMBER)
    @JsonView({ApiOutput.class, ApiInputCreate.class, ApiInputUpdate.class})
    @NotBlank(message = "{" + KEY_PHONE_NUMBER_BLANK + "}", groups = {ApiInputCreate.class, ApiOutput.class})
    @Size(min = 10, max = 15, message = "{" + KEY_PHONE_NUMBER_SIZE + "}", groups = {ApiInputCreate.class, ApiInputUpdate.class, ApiOutput.class})
    private String phoneNumber;

    @Schema(name = USER_FIELD_LAST_UPDATED_TIME, description = USER_LAST_UPDATED_TIME_DESCRIPTION, example = USER_EXAMPLE_LAST_UPDATED_TIME)
    @JsonProperty(USER_FIELD_LAST_UPDATED_TIME)
    @JsonView(ApiOutput.class)
    @NotNull(message = "{" + USER_LAST_UPDATED_NULL + "}", groups = ApiOutput.class)
    private LocalDateTime lastUpdatedTime;

    @Schema(name = USER_FIELD_CREATED_TIME, description = USER_CREATED_TIME_DESCRIPTION, example = USER_EXAMPLE_CREATED_TIME)
    @JsonProperty(USER_FIELD_CREATED_TIME)
    @JsonView(ApiOutput.class)
    @NotNull(message = "{" + USER_CREATED_TIME_NULL + "}", groups = ApiOutput.class)
    private LocalDateTime createdTime;
}

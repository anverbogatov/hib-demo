package ru.fullstackguy.hibdemo.api.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.fullstackguy.hibdemo.application.GroupApplicationService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GroupController.class)
class GroupControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupApplicationService groupApplicationService;

    @Test
    void createStudent() throws Exception {
        // when
        mockMvc.perform(post("/groups")
                        .header("Content-Type", "application/json")
                        .content("""
                                {
                                    "groupNumber": "403A",
                                    "groupDetails": {
                                        "telegramChannel": "group_403a"
                                    },
                                    "students": [
                                        {
                                            "name": "Boris",
                                            "passport": {
                                                "series": "3302",
                                                "number": "123456"
                                            },
                                            "subjects": [
                                                "Math",
                                                "Russian",
                                                "Physics"
                                            ]
                                        },
                                        {
                                            "name": "Anna",
                                            "passport": {
                                                "series": "1103",
                                                "number": "122233"
                                            },
                                            "subjects": [
                                                "English",
                                                "Russian",
                                                "Geography"
                                            ]
                                        }
                                    ]
                                }
                                """))
                // then
                .andExpect(status().isOk());

        verify(groupApplicationService, times(1))
                .createNewGroup(anyString(), anyString(), anyList());
    }

    @Test
    void createStudentWhenFail() throws Exception {
        // given
        doThrow(new RuntimeException())
                .when(groupApplicationService)
                .createNewGroup(anyString(), anyString(), anyList());

        // when
        mockMvc.perform(post("/groups")
                        .header("Content-Type", "application/json")
                        .content("""
                                {
                                    "groupNumber": "403A",
                                    "groupDetails": {
                                        "telegramChannel": "group_403a"
                                    },
                                    "students": [
                                        {
                                            "name": "Boris",
                                            "passport": {
                                                "series": "3302",
                                                "number": "123456"
                                            },
                                            "subjects": [
                                                "Math",
                                                "Russian",
                                                "Physics"
                                            ]
                                        },
                                        {
                                            "name": "Anna",
                                            "passport": {
                                                "series": "1103",
                                                "number": "122233"
                                            },
                                            "subjects": [
                                                "English",
                                                "Russian",
                                                "Geography"
                                            ]
                                        }
                                    ]
                                }
                                """))
                // then
                .andExpect(status().isInternalServerError());
    }
}
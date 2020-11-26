package com.minimed.MiniMedAPI.entity.patient;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Эмнэлэгээр Үйлчлүүлэгч
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends BaseModel {
    @NotNull
    @NotEmpty
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String uuid;

    private String firstName; //Өөрийн нэр
    private String lastName; //Овог

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String regNum; //Регистрийн дугаар

    private String addressUuid; //гэрийн хаяг

    private String cardNo; //Өвчтөний картын дугаар

    @Column(columnDefinition = "TEXT")
    private String mail; //Имэйл хаяг

    private String phone; //Гар утасны дугаар
    private LocalDateTime created; //Өвчтөнийг бүртгэж авсан огноо
}

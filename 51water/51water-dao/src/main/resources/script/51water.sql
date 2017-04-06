CREATE TABLE `51water`.`t_water_station` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `water_station_name` VARCHAR(100) NOT NULL COMMENT '水站名称',
  `water_station_code` VARCHAR(50) NOT NULL COMMENT '水站编码',
  `water_station_addr` VARCHAR(255) NOT NULL COMMENT '水站地址',
  `water_station_mp` CHAR(11) NOT NULL COMMENT '手机号码',
  `is_follow` TINYINT(1) NULL DEFAULT 0 COMMENT '是否加入企业号(0:未加入;1:已加入)',
  `open_time` TIME NOT NULL COMMENT '营业开始时间',
  `close_time` TIME NOT NULL COMMENT '营业结束时间',
  `follow_time` DATETIME NULL COMMENT '加入企业号的时间',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `water_station_code_UNIQUE` (`water_station_code` ASC)  COMMENT '')
COMMENT = '水站表';

CREATE TABLE `51water`.`t_water_brand` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `brand_name` VARCHAR(100) NOT NULL COMMENT '水的品牌名称 ',
  `price` INT(50) NOT NULL COMMENT '桶装水的价格',
  `station_Id` BIGINT NOT NULL COMMENT '水站ID',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  CONSTRAINT `FK_STATIONID_BRAND_BIND`
    FOREIGN KEY (`station_Id`)
    REFERENCES `51water`.`t_water_station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '水品牌';



CREATE TABLE `51water`.`t_employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `emp_name` VARCHAR(45) NULL COMMENT '员工名',
  `emp_mp` CHAR(11) NOT NULL COMMENT '员工手机号',
  `station_Id` BIGINT NOT NULL COMMENT '水站ID',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `emp_mp_UNIQUE` (`emp_mp` ASC)  COMMENT '',
  CONSTRAINT `FK_STATIONID_EMP`
  FOREIGN KEY (`station_Id`)
  REFERENCES `51water`.`t_water_station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  )COMMENT = '员工表';

CREATE TABLE `51water`.`t_usr` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `usr_name` VARCHAR(45) NULL COMMENT '用户名',
  `usr_code` VARCHAR(45) NOT NULL COMMENT '用户订水号',
  `usr_station_code` VARCHAR(45) NOT NULL COMMENT '用户编码+水站编码',
  `usr_openid` VARCHAR(45) NULL COMMENT 'OpenID',
  `follow_time` DATETIME NULL COMMENT '关注公众号的时间',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `usr_station_code_UNIQUE` (`usr_station_code` ASC)  COMMENT ''
  )COMMENT = '用户表';

  CREATE TABLE `51water`.`t_usr_acct` (
  `usrId` BIGINT NOT NULL COMMENT '',
  `water_ticket_num` INT NOT NULL DEFAULT 0 COMMENT '电子水票数量',
  `check_code` VARCHAR(100) NOT NULL COMMENT '电子水票数量校验码',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`usrId`)  COMMENT '')
COMMENT = '用户账户表';

ALTER TABLE `51water`.`t_usr_acct` 
ADD CONSTRAINT `FK_USRID`
  FOREIGN KEY (`usrId`)
  REFERENCES `51water`.`t_usr` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `51water`.`t_usr_water_station` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `usrId` BIGINT NOT NULL COMMENT '用户主键',
  `stationId` BIGINT NOT NULL COMMENT '水站主键',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_USRID_BIND_idx` (`usrId` ASC)  COMMENT '',
  INDEX `FK_STATIONID_BIND_idx` (`stationId` ASC)  COMMENT '',
  UNIQUE INDEX `UN_STATION_USR` (`usrId` ASC, `stationId` ASC)  COMMENT '',
  CONSTRAINT `FK_USRID_BIND`
    FOREIGN KEY (`usrId`)
    REFERENCES `51water`.`t_usr` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_STATIONID_BIND`
    FOREIGN KEY (`stationId`)
    REFERENCES `51water`.`t_water_station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '用户水站绑定表';

CREATE TABLE `51water`.`t_payment_modes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `modes` INT NULL DEFAULT 1 COMMENT '支付方式(1:线下支付;2:电子水票支付)',
  `modes_descp` VARCHAR(100) NULL COMMENT '支付方式描述',
 `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '')
COMMENT = '支付方式';

CREATE TABLE `51water`.`t_delivery_cfg` (
  `id` BIGINT NOT NULL COMMENT '',
  `usr_station_Id` BIGINT NULL COMMENT '',
  `delivery_addr` VARCHAR(255) NOT NULL COMMENT '配送地址',
  `number` INT NOT NULL DEFAULT 1 COMMENT '订水数量',
  `brand` VARCHAR(255) NOT NULL COMMENT '品牌',
  `modesId` BIGINT NOT NULL COMMENT '支付方式ID',
  `delivery_time` DATETIME  NULL COMMENT '',
  `default_cfg` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '默认配送地址(0:非默认配送地址;1:默认配送地址)',
   `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_usr_station_delivery_idx` (`usr_station_Id` ASC)  COMMENT '',
  INDEX `FK_payment_modes_delivery_idx` (`modesId` ASC)  COMMENT '',
  CONSTRAINT `FK_usr_station_delivery`
    FOREIGN KEY (`usr_station_Id`)
    REFERENCES `51water`.`t_usr_water_station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_payment_modes_delivery`
    FOREIGN KEY (`modesId`)
    REFERENCES `51water`.`t_payment_modes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '配送配置';


CREATE TABLE `51water`.`t_order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `usrId` BIGINT NOT NULL COMMENT '用户主键',
  `number` INT NOT NULL COMMENT '订水数量',
  `delivery_cfg_id` BIGINT NOT NULL COMMENT '配置表主键',
  `amount` BIGINT NOT NULL COMMENT '订单金额',
  `real_amount` BIGINT NOT NULL COMMENT '实际支付金额',
  `order_status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '订单状态(0:初始;2:付款;1:取消;4:送货;3:退货;5:退款;6:完成)',
  `note` VARCHAR(255)  COMMENT '备注信息',
   `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `FK_ORDER_USRID_idx` (`usrId` ASC)  COMMENT '',
  INDEX `FK_ORDER_DELIVERY_idx` (`delivery_cfg_id` ASC)  COMMENT '',
  CONSTRAINT `FK_ORDER_USRID`
    FOREIGN KEY (`usrId`)
    REFERENCES `51water`.`t_usr` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ORDER_DELIVERY`
    FOREIGN KEY (`delivery_cfg_id`)
    REFERENCES `51water`.`t_delivery_cfg` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '订单';



CREATE TABLE `51water`.`t_employee_delivery` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `emp_id` BIGINT NOT NULL COMMENT '员工ID',
  `order_id` BIGINT NOT NULL COMMENT '订单ID',
  `is_delivered` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '该条派送记录是否派送(0:未派送,1:已派送)',
  `creation_time` DATETIME NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `modification_time` DATETIME NULL COMMENT '修改时间',
  `valid` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '该条记录是否有效(0:无效,1:有效)',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC)  COMMENT '',
  CONSTRAINT `FK_DELIVERY_ORDER_ID`
  FOREIGN KEY (`order_id`)
  REFERENCES `51water`.`t_order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_DELIVERY_EMP_ID`
  FOREIGN KEY (`emp_id`)
  REFERENCES `51water`.`t_employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)COMMENT = '员工表配送';
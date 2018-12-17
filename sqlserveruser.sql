/*
Navicat SQL Server Data Transfer

Source Server         : erpServerSql
Source Server Version : 90000
Source Host           : 192.168.1.244:1433
Source Database       : detectiontest
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 90000
File Encoding         : 65001

Date: 2018-12-17 10:38:48
*/


-- ----------------------------
-- Table structure for sqlserveruser
-- ----------------------------
DROP TABLE [dbo].[sqlserveruser]
GO
CREATE TABLE [dbo].[sqlserveruser] (
[id] int NOT NULL ,
[name] varchar(33) NULL ,
[address] varchar(33) NULL 
)


GO

-- ----------------------------
-- Records of sqlserveruser
-- ----------------------------
INSERT INTO [dbo].[sqlserveruser] ([id], [name], [address]) VALUES (N'1', N'1', N'1')
GO
GO
INSERT INTO [dbo].[sqlserveruser] ([id], [name], [address]) VALUES (N'2', N'2', N'2')
GO
GO
INSERT INTO [dbo].[sqlserveruser] ([id], [name], [address]) VALUES (N'3', N'3', N'3')
GO
GO
INSERT INTO [dbo].[sqlserveruser] ([id], [name], [address]) VALUES (N'4', N'4', N'4')
GO
GO
INSERT INTO [dbo].[sqlserveruser] ([id], [name], [address]) VALUES (N'5', N'5', N'5')
GO
GO

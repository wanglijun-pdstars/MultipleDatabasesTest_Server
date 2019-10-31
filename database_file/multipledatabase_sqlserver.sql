/*
 Navicat SQL Server Data Transfer

 Source Server         : 192.168.24.15
 Source Server Type    : SQL Server
 Source Server Version : 14001000
 Source Host           : 192.168.24.15:1433
 Source Catalog        : multipledatabase
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 14001000
 File Encoding         : 65001

 Date: 31/10/2019 15:26:09
*/


-- ----------------------------
-- Table structure for detail
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[detail]') AND type IN ('U'))
	DROP TABLE [dbo].[detail]
GO

CREATE TABLE [dbo].[detail] (
  [id] bigint  IDENTITY(15,1) NOT NULL,
  [type_id] bigint DEFAULT NULL NULL,
  [count] int DEFAULT NULL NULL,
  [insert_time] datetime DEFAULT (getdate()) NULL
)
GO

ALTER TABLE [dbo].[detail] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of detail
-- ----------------------------
SET IDENTITY_INSERT [dbo].[detail] ON
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'1', N'1', N'1', N'2019-10-02 13:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'2', N'1', N'2', N'2019-10-02 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'3', N'1', N'2', N'2019-10-03 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'4', N'1', N'4', N'2019-10-04 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'5', N'1', N'5', N'2019-10-05 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'6', N'1', N'4', N'2019-10-06 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'7', N'1', N'3', N'2019-10-07 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'8', N'2', N'1', N'2019-10-01 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'9', N'2', N'3', N'2019-10-02 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'10', N'2', N'4', N'2019-10-03 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'11', N'2', N'1', N'2019-10-04 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'12', N'2', N'3', N'2019-10-05 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'13', N'2', N'4', N'2019-10-06 12:12:12.000')
GO

INSERT INTO [dbo].[detail] ([id], [type_id], [count], [insert_time]) VALUES (N'14', N'2', N'1', N'2019-10-07 12:12:12.000')
GO

SET IDENTITY_INSERT [dbo].[detail] OFF
GO


-- ----------------------------
-- Table structure for type
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[type]') AND type IN ('U'))
	DROP TABLE [dbo].[type]
GO

CREATE TABLE [dbo].[type] (
  [id] bigint  IDENTITY(5,1) NOT NULL,
  [type] nvarchar(45) COLLATE Chinese_PRC_CI_AS DEFAULT NULL NULL
)
GO

ALTER TABLE [dbo].[type] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of type
-- ----------------------------
SET IDENTITY_INSERT [dbo].[type] ON
GO

INSERT INTO [dbo].[type] ([id], [type]) VALUES (N'1', N'类型1')
GO

INSERT INTO [dbo].[type] ([id], [type]) VALUES (N'2', N'类型2')
GO

SET IDENTITY_INSERT [dbo].[type] OFF
GO


-- ----------------------------
-- Auto increment value for detail
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[detail]', RESEED, 15)
GO


-- ----------------------------
-- Primary Key structure for table detail
-- ----------------------------
ALTER TABLE [dbo].[detail] ADD CONSTRAINT [PK_detail_id] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for type
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[type]', RESEED, 5)
GO


-- ----------------------------
-- Primary Key structure for table type
-- ----------------------------
ALTER TABLE [dbo].[type] ADD CONSTRAINT [PK_type_id] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


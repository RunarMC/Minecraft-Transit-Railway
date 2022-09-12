package mtr;

import mtr.block.*;
import mtr.data.TransportMode;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


public interface Blocks {

	RegistryObject<Block> APG_DOOR = new RegistryObject<>(BlockAPGDoor::new);
	RegistryObject<Block> APG_GLASS = new RegistryObject<>(BlockAPGGlass::new);
	RegistryObject<Block> APG_GLASS_END = new RegistryObject<>(BlockAPGGlassEnd::new);
	RegistryObject<Block> ARRIVAL_PROJECTOR_1_SMALL = new RegistryObject<>(BlockArrivalProjector1Small::new);
	RegistryObject<Block> ARRIVAL_PROJECTOR_1_MEDIUM = new RegistryObject<>(BlockArrivalProjector1Medium::new);
	RegistryObject<Block> ARRIVAL_PROJECTOR_1_LARGE = new RegistryObject<>(BlockArrivalProjector1Large::new);
	RegistryObject<Block> CEILING = new RegistryObject<>(() -> new BlockCeilingAuto(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 15)));
	RegistryObject<Block> CEILING_LIGHT = new RegistryObject<>(() -> new BlockCeiling(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 15)));
	RegistryObject<Block> CEILING_NO_LIGHT = new RegistryObject<>(() -> new BlockCeiling(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2)));
	RegistryObject<Block> CLOCK = new RegistryObject<>(() -> new BlockClock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 5)));
	RegistryObject<Block> CLOCK_POLE = new RegistryObject<>(() -> new BlockClockPole(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> ESCALATOR_SIDE = new RegistryObject<>(BlockEscalatorSide::new);
	RegistryObject<Block> ESCALATOR_STEP = new RegistryObject<>(BlockEscalatorStep::new);
	RegistryObject<Block> GLASS_FENCE_CIO = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_CKT = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_HEO = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_MOS = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_PLAIN = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_SHM = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_STAINED = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_STW = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_TSH = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> GLASS_FENCE_WKS = new RegistryObject<>(BlockGlassFence::new);
	RegistryObject<Block> LOGO = new RegistryObject<>(() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 10)));
	RegistryObject<Block> LIFT_BUTTONS_1 = new RegistryObject<>(BlockLiftButtons::new);
	RegistryObject<Block> LIFT_TRACK_1 = new RegistryObject<>(BlockLiftTrack::new);
	RegistryObject<Block> LIFT_TRACK_FLOOR_1 = new RegistryObject<>(BlockLiftTrackFloor::new);
	RegistryObject<Block> LIFT_DOOR_1 = new RegistryObject<>(BlockLiftDoor::new);
	RegistryObject<Block> LIFT_DOOR_ODD_1 = new RegistryObject<>(BlockLiftDoorOdd::new);
	RegistryObject<Block> MARBLE_BLUE = new RegistryObject<>(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> MARBLE_BLUE_SLAB = new RegistryObject<>(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> MARBLE_SANDY = new RegistryObject<>(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> MARBLE_SANDY_SLAB = new RegistryObject<>(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> PIDS_1 = new RegistryObject<>(BlockPIDS1::new);
	RegistryObject<Block> PIDS_2 = new RegistryObject<>(BlockPIDS2::new);
	RegistryObject<Block> PIDS_3 = new RegistryObject<>(BlockPIDS3::new);
	RegistryObject<Block> PIDS_POLE = new RegistryObject<>(() -> new BlockPIDSPole(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1)));
	RegistryObject<Block> PLATFORM = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), false));
	RegistryObject<Block> PLATFORM_INDENTED = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2).noOcclusion(), true));
	RegistryObject<Block> PLATFORM_NA_1 = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), false));
	RegistryObject<Block> PLATFORM_NA_1_INDENTED = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2).noOcclusion(), true));
	RegistryObject<Block> PLATFORM_NA_2 = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), false));
	RegistryObject<Block> PLATFORM_NA_2_INDENTED = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2).noOcclusion(), true));
	RegistryObject<Block> PLATFORM_UK_1 = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2), false));
	RegistryObject<Block> PLATFORM_UK_1_INDENTED = new RegistryObject<>(() -> new BlockPlatform(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(2).noOcclusion(), true));
	RegistryObject<Block> PSD_DOOR_1 = new RegistryObject<>(() -> new BlockPSDDoor(0));
	RegistryObject<Block> PSD_GLASS_1 = new RegistryObject<>(() -> new BlockPSDGlass(0));
	RegistryObject<Block> PSD_GLASS_END_1 = new RegistryObject<>(() -> new BlockPSDGlassEnd(0));
	RegistryObject<Block> PSD_DOOR_2 = new RegistryObject<>(() -> new BlockPSDDoor(1));
	RegistryObject<Block> PSD_GLASS_2 = new RegistryObject<>(() -> new BlockPSDGlass(1));
	RegistryObject<Block> PSD_GLASS_END_2 = new RegistryObject<>(() -> new BlockPSDGlassEnd(1));
	RegistryObject<Block> PSD_TOP = new RegistryObject<>(BlockPSDTop::new);
	RegistryObject<Block> RAIL_NODE = new RegistryObject<>(() -> new BlockNode(TransportMode.TRAIN));
	RegistryObject<Block> BOAT_NODE = new RegistryObject<>(BlockNode.BlockBoatNode::new);
	RegistryObject<Block> CABLE_CAR_NODE_LOWER = new RegistryObject<>(() -> new BlockNode.BlockContinuousMovementNode(false, false));
	RegistryObject<Block> CABLE_CAR_NODE_UPPER = new RegistryObject<>(() -> new BlockNode.BlockContinuousMovementNode(true, false));
	RegistryObject<Block> CABLE_CAR_NODE_STATION = new RegistryObject<>(() -> new BlockNode.BlockContinuousMovementNode(false, true));
	RegistryObject<Block> RAILWAY_SIGN_2_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(2, false));
	RegistryObject<Block> RAILWAY_SIGN_2_ODD = new RegistryObject<>(() -> new BlockRailwaySign(2, true));
	RegistryObject<Block> RAILWAY_SIGN_3_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(3, false));
	RegistryObject<Block> RAILWAY_SIGN_3_ODD = new RegistryObject<>(() -> new BlockRailwaySign(3, true));
	RegistryObject<Block> RAILWAY_SIGN_4_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(4, false));
	RegistryObject<Block> RAILWAY_SIGN_4_ODD = new RegistryObject<>(() -> new BlockRailwaySign(4, true));
	RegistryObject<Block> RAILWAY_SIGN_5_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(5, false));
	RegistryObject<Block> RAILWAY_SIGN_5_ODD = new RegistryObject<>(() -> new BlockRailwaySign(5, true));
	RegistryObject<Block> RAILWAY_SIGN_6_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(6, false));
	RegistryObject<Block> RAILWAY_SIGN_6_ODD = new RegistryObject<>(() -> new BlockRailwaySign(6, true));
	RegistryObject<Block> RAILWAY_SIGN_7_EVEN = new RegistryObject<>(() -> new BlockRailwaySign(7, false));
	RegistryObject<Block> RAILWAY_SIGN_7_ODD = new RegistryObject<>(() -> new BlockRailwaySign(7, true));
	RegistryObject<Block> RAILWAY_SIGN_MIDDLE = new RegistryObject<>(() -> new BlockRailwaySign(0, false));
	RegistryObject<Block> RAILWAY_SIGN_POLE = new RegistryObject<>(() -> new BlockRailwaySignPole(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(1).noOcclusion()));
	RegistryObject<Block> ROUTE_SIGN_STANDING_LIGHT = new RegistryObject<>(BlockRouteSignStandingLight::new);
	RegistryObject<Block> ROUTE_SIGN_STANDING_METAL = new RegistryObject<>(BlockRouteSignStandingMetal::new);
	RegistryObject<Block> ROUTE_SIGN_WALL_LIGHT = new RegistryObject<>(BlockRouteSignWallLight::new);
	RegistryObject<Block> ROUTE_SIGN_WALL_METAL = new RegistryObject<>(BlockRouteSignWallMetal::new);
	RegistryObject<Block> RUBBISH_BIN_1 = new RegistryObject<>(() -> new BlockRubbishBin(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(4)));
	RegistryObject<Block> SIGNAL_LIGHT_1 = new RegistryObject<>(() -> new BlockSignalLight1(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_LIGHT_2 = new RegistryObject<>(() -> new BlockSignalLight2(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_LIGHT_3 = new RegistryObject<>(() -> new BlockSignalLight3(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_LIGHT_4 = new RegistryObject<>(() -> new BlockSignalLight4(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_SEMAPHORE_1 = new RegistryObject<>(() -> new BlockSignalSemaphore1(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_SEMAPHORE_2 = new RegistryObject<>(() -> new BlockSignalSemaphore2(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(4)));
	RegistryObject<Block> SIGNAL_POLE = new RegistryObject<>(() -> new BlockStationColorPole(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).noOcclusion(), false));
	RegistryObject<Block> STATION_COLOR_ANDESITE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.ANDESITE)));

	RegistryObject<Block> STATION_COLOR_BEDROCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)));
	RegistryObject<Block> STATION_COLOR_BIRCH_WOOD = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.BIRCH_WOOD)));
	RegistryObject<Block> STATION_COLOR_BONE_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.BONE_BLOCK)));
	RegistryObject<Block> STATION_COLOR_CHISELED_QUARTZ_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CHISELED_QUARTZ_BLOCK)));
	RegistryObject<Block> STATION_COLOR_CHISELED_STONE_BRICKS = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CHISELED_STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_CLAY = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CLAY)));
	RegistryObject<Block> STATION_COLOR_COAL_ORE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COAL_ORE)));
	RegistryObject<Block> STATION_COLOR_COBBLESTONE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE)));
	RegistryObject<Block> STATION_COLOR_CONCRETE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_CONCRETE)));
	RegistryObject<Block> STATION_COLOR_CONCRETE_POWDER = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_CONCRETE_POWDER)));
	RegistryObject<Block> STATION_COLOR_CRACKED_STONE_BRICKS = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CRACKED_STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_DARK_PRISMARINE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DARK_PRISMARINE)));
	RegistryObject<Block> STATION_COLOR_DIORITE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIORITE)));
	RegistryObject<Block> STATION_COLOR_GRAVEL = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GRAVEL)));
	RegistryObject<Block> STATION_COLOR_IRON_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK)));
	RegistryObject<Block> STATION_COLOR_METAL = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 10)));
	RegistryObject<Block> STATION_COLOR_PLANKS = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_PLANKS)));
	RegistryObject<Block> STATION_COLOR_POLE = new RegistryObject<>(() -> new BlockStationColorPole(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(2).noOcclusion(), true));
	RegistryObject<Block> STATION_COLOR_POLISHED_ANDESITE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE)));
	RegistryObject<Block> STATION_COLOR_POLISHED_DIORITE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.POLISHED_DIORITE)));
	RegistryObject<Block> STATION_COLOR_PURPUR_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.PURPUR_BLOCK)));
	RegistryObject<Block> STATION_COLOR_PURPUR_PILLAR = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.PURPUR_PILLAR)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_BLOCK)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_BRICKS = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_BRICKS)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_PILLAR = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_PILLAR)));
	RegistryObject<Block> STATION_COLOR_SMOOTH_QUARTZ = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.SMOOTH_QUARTZ)));
	RegistryObject<Block> STATION_COLOR_SMOOTH_STONE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.SMOOTH_STONE)));
	RegistryObject<Block> STATION_COLOR_SNOW_BLOCK = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_WOOL)));
	RegistryObject<Block> STATION_COLOR_STAINED_GLASS = new RegistryObject<>(() -> new BlockStationColorGlass(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_STAINED_GLASS)));
	RegistryObject<Block> STATION_COLOR_STONE = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)));
	RegistryObject<Block> STATION_COLOR_STONE_BRICKS = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_WOOL = new RegistryObject<>(() -> new BlockStationColor(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_WOOL)));

	RegistryObject<Block> STATION_COLOR_ANDESITE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.ANDESITE)));
	RegistryObject<Block> STATION_COLOR_BEDROCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)));
	RegistryObject<Block> STATION_COLOR_BIRCH_WOOD_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.BIRCH_WOOD)));
	RegistryObject<Block> STATION_COLOR_BONE_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.BONE_BLOCK)));
	RegistryObject<Block> STATION_COLOR_CHISELED_QUARTZ_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CHISELED_QUARTZ_BLOCK)));
	RegistryObject<Block> STATION_COLOR_CHISELED_STONE_BRICKS_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CHISELED_STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_CLAY_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CLAY)));
	RegistryObject<Block> STATION_COLOR_COAL_ORE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COAL_ORE)));
	RegistryObject<Block> STATION_COLOR_COBBLESTONE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE)));
	RegistryObject<Block> STATION_COLOR_CONCRETE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_CONCRETE)));
	RegistryObject<Block> STATION_COLOR_CONCRETE_POWDER_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_CONCRETE_POWDER)));
	RegistryObject<Block> STATION_COLOR_CRACKED_STONE_BRICKS_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CRACKED_STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_DARK_PRISMARINE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DARK_PRISMARINE)));
	RegistryObject<Block> STATION_COLOR_DIORITE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIORITE)));
	RegistryObject<Block> STATION_COLOR_GRAVEL_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GRAVEL)));
	RegistryObject<Block> STATION_COLOR_IRON_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK)));
	RegistryObject<Block> STATION_COLOR_METAL_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 10)));
	RegistryObject<Block> STATION_COLOR_PLANKS_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_PLANKS)));
	RegistryObject<Block> STATION_COLOR_POLISHED_ANDESITE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.POLISHED_ANDESITE)));
	RegistryObject<Block> STATION_COLOR_POLISHED_DIORITE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.POLISHED_DIORITE)));
	RegistryObject<Block> STATION_COLOR_PURPUR_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.PURPUR_BLOCK)));
	RegistryObject<Block> STATION_COLOR_PURPUR_PILLAR_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.PURPUR_PILLAR)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_BLOCK)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_BRICKS_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_BRICKS)));
	RegistryObject<Block> STATION_COLOR_QUARTZ_PILLAR_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.QUARTZ_PILLAR)));
	RegistryObject<Block> STATION_COLOR_SMOOTH_QUARTZ_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.SMOOTH_QUARTZ)));
	RegistryObject<Block> STATION_COLOR_SMOOTH_STONE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.SMOOTH_STONE)));
	RegistryObject<Block> STATION_COLOR_SNOW_BLOCK_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_WOOL)));
	RegistryObject<Block> STATION_COLOR_STAINED_GLASS_SLAB = new RegistryObject<>(() -> new BlockStationColorGlassSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_STAINED_GLASS).noOcclusion()));
	RegistryObject<Block> STATION_COLOR_STONE_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)));
	RegistryObject<Block> STATION_COLOR_STONE_BRICKS_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS)));
	RegistryObject<Block> STATION_COLOR_WOOL_SLAB = new RegistryObject<>(() -> new BlockStationColorSlab(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHITE_WOOL)));

	RegistryObject<Block> STATION_NAME_ENTRANCE = new RegistryObject<>(() -> new BlockStationNameEntrance(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> STATION_NAME_TALL_BLOCK = new RegistryObject<>(BlockStationNameTallBlock::new);
	RegistryObject<Block> STATION_NAME_TALL_BLOCK_DOUBLE_SIDED = new RegistryObject<>(BlockStationNameTallBlockDoubleSided::new);
	RegistryObject<Block> STATION_NAME_TALL_WALL = new RegistryObject<>(BlockStationNameTallWall::new);
	RegistryObject<Block> STATION_NAME_WALL_WHITE = new RegistryObject<>(() -> new BlockStationNameWallWhite(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> STATION_NAME_WALL_GRAY = new RegistryObject<>(() -> new BlockStationNameWallGray(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> STATION_NAME_WALL_BLACK = new RegistryObject<>(() -> new BlockStationNameWallBlack(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TACTILE_MAP = new RegistryObject<>(() -> new BlockTactileMap(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2).noOcclusion()));
	RegistryObject<Block> TICKET_BARRIER_ENTRANCE_1 = new RegistryObject<>(() -> new BlockTicketBarrier(true));
	RegistryObject<Block> TICKET_BARRIER_EXIT_1 = new RegistryObject<>(() -> new BlockTicketBarrier(false));
	RegistryObject<Block> TICKET_MACHINE = new RegistryObject<>(() -> new BlockTicketMachine(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2).lightLevel(state -> 5).noOcclusion()));
	RegistryObject<Block> TICKET_PROCESSOR = new RegistryObject<>(() -> new BlockTicketProcessor(true, true, true));
	RegistryObject<Block> TICKET_PROCESSOR_ENTRANCE = new RegistryObject<>(() -> new BlockTicketProcessor(true, true, false));
	RegistryObject<Block> TICKET_PROCESSOR_EXIT = new RegistryObject<>(() -> new BlockTicketProcessor(true, false, true));
	RegistryObject<Block> TICKET_PROCESSOR_ENQUIRY = new RegistryObject<>(BlockTicketProcessorEnquiry::new);
	RegistryObject<Block> TRAIN_ANNOUNCER = new RegistryObject<>(BlockTrainAnnouncer::new);
	RegistryObject<Block> TRAIN_CARGO_LOADER = new RegistryObject<>(BlockTrainCargoLoader::new);
	RegistryObject<Block> TRAIN_CARGO_UNLOADER = new RegistryObject<>(BlockTrainCargoUnloader::new);
	RegistryObject<Block> TRAIN_REDSTONE_SENSOR = new RegistryObject<>(BlockTrainRedstoneSensor::new);
	RegistryObject<Block> TRAIN_SCHEDULE_SENSOR = new RegistryObject<>(BlockTrainScheduleSensor::new);
}
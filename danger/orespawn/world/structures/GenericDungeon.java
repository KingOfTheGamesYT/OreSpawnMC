/*     */ package danger.orespawn.world.structures;
/*     */ 
/*     */ import net.minecraft.block.BlockChest;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GenericDungeon
/*     */ {
/*  42 */   private ResourceLocation LOOT_TABLE = new ResourceLocation("orespawn", "generic_dungeon");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setThisBlock(World world, int cposx, int cposy, int cposz) {
/* 148 */     if (world.rand.nextInt(2) == 1) {
/* 149 */       world.setBlockState(new BlockPos(cposx, cposy, cposz), Blocks.MOSSY_COBBLESTONE.getDefaultState());
/*     */     } else {
/*     */       
/* 152 */       world.setBlockState(new BlockPos(cposx, cposy, cposz), Blocks.COBBLESTONE.getDefaultState());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private TileEntityChest getChestTileEntity(World world, int cposx, int cposy, int cposz) {
/* 159 */     TileEntityChest chest = null;
/* 160 */     TileEntity t = null;
/* 161 */     t = world.getTileEntity(new BlockPos(cposx, cposy, cposz));
/* 162 */     if (t instanceof TileEntityChest) {
/* 163 */       chest = (TileEntityChest)t;
/*     */     }
/* 165 */     return chest;
/*     */   }
/*     */ 
/*     */   
/*     */   private TileEntityMobSpawner getSpawnerTileEntity(World world, int cposx, int cposy, int cposz) {
/* 170 */     TileEntityMobSpawner chest = null;
/* 171 */     TileEntity t = null;
/* 172 */     t = world.getTileEntity(new BlockPos(cposx, cposy, cposz));
/* 173 */     if (t instanceof TileEntityMobSpawner) {
/* 174 */       chest = (TileEntityMobSpawner)t;
/* 175 */       return chest;
/*     */     } 
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void makeDungeon(World world, int cposx, int cposy, int cposz) {
/* 184 */     int width = 12;
/* 185 */     int height = 6;
/*     */     
/*     */     int i;
/* 188 */     for (i = 0; i < width; i++) {
/* 189 */       for (int j = 0; j < height; j++) {
/* 190 */         for (int m = 0; m < width; m++) {
/* 191 */           world.setBlockState(new BlockPos(cposx + i, cposy + j, cposz + m), Blocks.AIR.getDefaultState());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 198 */     for (i = 0; i < width; i++) {
/* 199 */       int j = 0;
/* 200 */       for (int m = 0; m < width; m++) {
/* 201 */         world.setBlockState(new BlockPos(cposx + i, cposy + j, cposz + m), Blocks.MOSSY_COBBLESTONE.getDefaultState());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 207 */     for (i = 0; i < width; i++) {
/* 208 */       int j = height - 1;
/* 209 */       for (int m = 0; m < width; m++) {
/* 210 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 215 */     for (i = 0; i < width; i++) {
/* 216 */       for (int j = 0; j < height; j++) {
/* 217 */         int m = 0;
/* 218 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/* 219 */         m = width - 1;
/* 220 */         setThisBlock(world, cposx + i, cposy + j, cposz + m);
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     for (int k = 0; k < width; k++) {
/* 225 */       for (int j = 0; j < height; j++) {
/* 226 */         i = 0;
/* 227 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/* 228 */         i = width - 1;
/* 229 */         setThisBlock(world, cposx + i, cposy + j, cposz + k);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 235 */     world.setBlockState(new BlockPos(cposx + width / 2, cposy + 1, cposz + width / 2), Blocks.MOB_SPAWNER.getDefaultState());
/*     */     
/* 237 */     TileEntityMobSpawner tileentitymobspawner = getSpawnerTileEntity(world, cposx + width / 2, cposy + 1, cposz + width / 2);
/*     */     
/* 239 */     if (tileentitymobspawner != null) {
/*     */       
/* 241 */       int t = world.rand.nextInt(3);
/* 242 */       if (t == 0) tileentitymobspawner.getSpawnerBaseLogic().setEntityId(new ResourceLocation("orespawn:alien")); 
/* 243 */       if (t == 1) tileentitymobspawner.getSpawnerBaseLogic().setEntityId(new ResourceLocation("orespawn:gammametroid")); 
/* 244 */       if (t == 2) tileentitymobspawner.getSpawnerBaseLogic().setEntityId(new ResourceLocation("orespawn:cryolophosaurus"));
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 263 */     TileEntityChest chest = null;
/*     */     
/* 265 */     world.setBlockState(new BlockPos(cposx + width / 2, cposy + 1, cposz + 1), Blocks.CHEST.getDefaultState().withProperty((IProperty)BlockChest.FACING, (Comparable)EnumFacing.SOUTH));
/*     */     
/* 267 */     chest = getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
/* 268 */     if (chest != null)
/*     */     {
/*     */       
/* 271 */       chest.setLootTable(this.LOOT_TABLE, (world.rand.nextInt() * cposx * cposy * cposz));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\world\structures\GenericDungeon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package danger.orespawn.items;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.entity.EntityCage;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
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
/*     */ public class CritterCage
/*     */   extends Item
/*     */ {
/*  44 */   private static final ArrayList<CritterCage> critterCages = new ArrayList<>();
/*     */   
/*     */   private final float chance;
/*     */   
/*     */   public static final int entityIDOffset = 10;
/*     */   int entityID;
/*     */   
/*     */   public CritterCage(int entityID, String unlocalizedName) {
/*  52 */     this(entityID, unlocalizedName, 1.0F);
/*     */   }
/*     */   
/*     */   public CritterCage(int entityID, String unlocalizedName, float chance) {
/*  56 */     setUnlocalizedName(unlocalizedName);
/*  57 */     setRegistryName(unlocalizedName);
/*  58 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*     */     
/*  60 */     this.maxStackSize = 16;
/*  61 */     this.entityID = entityID + 10;
/*  62 */     this.chance = chance;
/*     */     
/*  64 */     ModItems.ITEMS.add(this);
/*  65 */     critterCages.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getChance() {
/*  70 */     return this.chance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
/*  79 */     ItemStack stack = player.getHeldItem(hand);
/*     */     
/*  81 */     EnumActionResult result = handleRightClick(world, player, hand, player.getPosition(), false);
/*     */     
/*  83 */     if (result == EnumActionResult.SUCCESS)
/*     */     {
/*  85 */       if (!player.isCreative())
/*     */       {
/*  87 */         stack.shrink(1);
/*     */       }
/*     */     }
/*  90 */     return new ActionResult(result, stack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing blockside, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
/*  96 */     EnumActionResult result = handleRightClick(world, player, hand, pos, true);
/*  97 */     if (result != EnumActionResult.FAIL && !player.isCreative())
/*     */     {
/*  99 */       player.getHeldItem(hand).shrink(1);
/*     */     }
/* 101 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumActionResult handleRightClick(World world, EntityPlayer entityPlayer, EnumHand hand, BlockPos position, boolean clickingOnBlock) {
/* 107 */     System.out.println(this.entityID);
/*     */     
/* 109 */     if (this.entityID == 0) {
/*     */       
/* 111 */       System.out.println("Throwing empty cage");
/* 112 */       if (!world.isRemote) {
/*     */         
/* 114 */         EntityCage ec = new EntityCage(world, entityPlayer, this.entityID, null);
/* 115 */         ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 116 */         world.spawnEntity((Entity)ec);
/*     */       } 
/*     */       
/* 119 */       world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 120 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 125 */     System.out.println("Throwing filled cage");
/* 126 */     if (clickingOnBlock) {
/*     */ 
/*     */       
/* 129 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 131 */         world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 132 */         world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 133 */         world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 135 */       world.playSound(entityPlayer, position, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 136 */       Entity summon = EntityList.createEntityByID(this.entityID - 10, world);
/*     */       
/* 138 */       summon.setPosition((position.getX() + 0.5F), (position.getY() + 1), (position.getZ() + 0.5F));
/* 139 */       world.spawnEntity(summon);
/*     */ 
/*     */       
/* 142 */       EntityItem empty = new EntityItem(world);
/* 143 */       empty.setItem(new ItemStack(ModItems.EMPTY_CAGE));
/* 144 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 145 */       world.spawnEntity((Entity)empty);
/*     */       
/* 147 */       ItemStack stack = entityPlayer.getHeldItem(hand);
/* 148 */       if (summon instanceof net.minecraft.entity.EntityLiving && stack.hasDisplayName())
/* 149 */         summon.setCustomNameTag(stack.getDisplayName()); 
/* 150 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */     
/* 154 */     if (!world.isRemote) {
/*     */       
/* 156 */       String name = null;
/* 157 */       if (entityPlayer.getHeldItem(hand).hasDisplayName())
/* 158 */         name = entityPlayer.getHeldItem(hand).getDisplayName(); 
/* 159 */       EntityCage ec = new EntityCage(world, entityPlayer, this.entityID, name);
/* 160 */       ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 161 */       world.spawnEntity((Entity)ec);
/*     */     } 
/*     */     
/* 164 */     world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 165 */     return EnumActionResult.SUCCESS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CritterCage getCageFromEntity(Entity e) {
/*     */     int ID;
/* 173 */     if (e == null) {
/* 174 */       ID = 0;
/*     */     } else {
/* 176 */       ID = EntityList.getID(e.getClass());
/* 177 */     }  for (CritterCage cc : critterCages) {
/*     */       
/* 179 */       if (cc.entityID == ID + 10)
/* 180 */         return cc; 
/*     */     } 
/* 182 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.3-deobf.jar!\danger\orespawn\items\CritterCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
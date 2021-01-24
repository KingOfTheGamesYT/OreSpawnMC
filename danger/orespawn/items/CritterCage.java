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
/*     */ 
/*     */ public class CritterCage
/*     */   extends Item
/*     */ {
/*  45 */   private static final ArrayList<CritterCage> critterCages = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private final float chance;
/*     */ 
/*     */   
/*     */   Class<? extends Entity> entityClass;
/*     */ 
/*     */   
/*     */   public CritterCage(Class<? extends Entity> entityClass, String unlocalizedName) {
/*  55 */     this(entityClass, unlocalizedName, 1.0F);
/*     */   }
/*     */   
/*     */   public CritterCage(Class<? extends Entity> entityClass, String unlocalizedName, float chance) {
/*  59 */     setUnlocalizedName(unlocalizedName);
/*  60 */     setRegistryName(unlocalizedName);
/*  61 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*     */     
/*  63 */     this.maxStackSize = 16;
/*  64 */     this.entityClass = entityClass;
/*  65 */     this.chance = chance;
/*     */     
/*  67 */     ModItems.ITEMS.add(this);
/*  68 */     critterCages.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getChance() {
/*  73 */     return this.chance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
/*  82 */     ItemStack stack = player.getHeldItem(hand);
/*     */     
/*  84 */     EnumActionResult result = handleRightClick(world, player, hand, player.getPosition(), false);
/*     */     
/*  86 */     if (result == EnumActionResult.SUCCESS)
/*     */     {
/*  88 */       if (!player.isCreative())
/*     */       {
/*  90 */         stack.shrink(1);
/*     */       }
/*     */     }
/*  93 */     return new ActionResult(result, stack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing blockside, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
/*  99 */     EnumActionResult result = handleRightClick(world, player, hand, pos, true);
/* 100 */     if (result != EnumActionResult.FAIL && !player.isCreative())
/*     */     {
/* 102 */       player.getHeldItem(hand).shrink(1);
/*     */     }
/* 104 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumActionResult handleRightClick(World world, EntityPlayer entityPlayer, EnumHand hand, BlockPos position, boolean clickingOnBlock) {
/* 111 */     if (this.entityClass == null) {
/*     */       
/* 113 */       System.out.println("Throwing empty cage");
/* 114 */       if (!world.isRemote) {
/*     */         
/* 116 */         EntityCage ec = new EntityCage(world, entityPlayer, this.entityClass, null);
/* 117 */         ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 118 */         world.spawnEntity((Entity)ec);
/*     */       } 
/*     */       
/* 121 */       world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 122 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (world.isRemote) return EnumActionResult.SUCCESS; 
/* 128 */     if (clickingOnBlock) {
/*     */ 
/*     */       
/* 131 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 133 */         world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 134 */         world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 135 */         world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 137 */       world.playSound(entityPlayer, position, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F);
/*     */       
/* 139 */       Entity summon = EntityList.newEntity(this.entityClass, world);
/*     */       
/* 141 */       summon.setPosition((position.getX() + 0.5F), (position.getY() + 1), (position.getZ() + 0.5F));
/* 142 */       world.spawnEntity(summon);
/*     */ 
/*     */       
/* 145 */       EntityItem empty = new EntityItem(world);
/* 146 */       empty.setItem(new ItemStack(ModItems.EMPTY_CAGE));
/* 147 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 148 */       world.spawnEntity((Entity)empty);
/*     */       
/* 150 */       ItemStack stack = entityPlayer.getHeldItem(hand);
/* 151 */       if (summon instanceof net.minecraft.entity.EntityLiving && stack.hasDisplayName())
/* 152 */         summon.setCustomNameTag(stack.getDisplayName()); 
/* 153 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */     
/* 157 */     if (!world.isRemote) {
/*     */       
/* 159 */       String name = null;
/* 160 */       if (entityPlayer.getHeldItem(hand).hasDisplayName())
/* 161 */         name = entityPlayer.getHeldItem(hand).getDisplayName(); 
/* 162 */       EntityCage ec = new EntityCage(world, entityPlayer, this.entityClass, name);
/* 163 */       ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 164 */       world.spawnEntity((Entity)ec);
/*     */     } 
/*     */     
/* 167 */     world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 168 */     return EnumActionResult.SUCCESS;
/*     */   }
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
/*     */   public static CritterCage getCageFromEntity(Entity e) {
/* 182 */     for (CritterCage cc : critterCages) {
/* 183 */       if (cc.entityClass == e.getClass()) {
/* 184 */         return cc;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\items\CritterCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */